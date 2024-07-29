package com.compassion.commons.tokens;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheEventListenerConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.ehcache.event.EventType;
import org.jooq.lambda.tuple.Tuple2;

import com.compassion.commons.LambdaUtils;
import com.compassion.commons.StatusMonitor;
import com.compassion.commons.Utilities;
import com.compassion.commons.hash.DataHash;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import lombok.extern.log4j.Log4j2;

/**
 * <p>Maintains a set of {@link TokenVector} instances. Uses a persistent cache
 * to cap memory usage.</p>
 * 
 * @param <TV> the type of token vectors in this set. Usually this is just {@link TokenVector} but could be a subclass.
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 2, 2013
 */
@Log4j2
public class TokenVectorSet<TV extends TokenVector> implements Iterable<TV>, AutoCloseable, CacheEventListener<Long, TV> {
	// Ehcache needs unique IDs for the file system
	private static final Map<String, TokenVectorSet<?>> all = new HashMap<>();
	private int idDeconflict = 1;
	
	private static final long
		// Always leave 2GB RAM for the next corpus and overhead associated with loading/parsing
		RAM_LEAVE_FREE = MemoryUnit.GB.toBytes(2),
		// But ensure there is at least 100 MB of RAM in the cache
		MIN_RAM = MemoryUnit.MB.toBytes(100);
	
	// Unique identifier for this hash set
	@Getter
	@Setter(AccessLevel.PROTECTED) private String name;
	// Maps token hash codes back to their original strings
	private TokenRegistry tokens;
	// Token vectors, backed by a file in the temp directory
	@Getter(AccessLevel.PACKAGE)
	private CacheManager cacheManager;
	private Cache<Long, TV> vectors;
	
	// Token document frequencies and inverse document weights
	private TokenVector tfidf;
	// The overall count of all tokens, cached so that callers don't need to deserialize vectors to compute this
	@Getter private long totalTokenCount;
	// Cache the keys for faster iteration - using cache's iterator always seems to hit the disk regardless, but
	// get()ing each key can use only heap if all vectors are in the heap
	private LongHashSet keys;

	/**
	 * Creates a new token vector set.
	 * @param name a unique identifier for this set
	 * @param tvClass the type of token vectors in this class, usually {@link TokenVector} itself but could be a subclass
	 */ 
	public TokenVectorSet(String name, Class<TV> tvClass) { this(name, tvClass, 1, false); }
	
	/**
	 * Creates a new token vector set.
	 * @param name a unique identifier for this set
	 * @param tvClass the type of token vectors in this class, usually {@link TokenVector} itself but could be a subclass
	 * @param concurrency the expected number of threads that will be accessing this corpus concurrently. This is just
	 * a hint that can improve performance - the default is {@code 1}.
	 * @param inMemory if this token vector set will only be holding a small amount of data and should keep all data in
	 * memory and avoid the overhead associated with spilling data to disk 
	 */ 
	public TokenVectorSet(String name, Class<TV> tvClass, int concurrency, boolean inMemory) {
		name = RegExUtils.replacePattern(name, "\\W+", "-");
		synchronized (all) {
			val existing = all.get(name);
			if (existing != null) { name = name + "-" + ++existing.idDeconflict; }
			all.put(this.name = name, this);
		}
		
		val rt = Runtime.getRuntime();
		rt.gc(); rt.gc(); rt.gc();
		val maxHeap = Math.max(rt.freeMemory() + (rt.maxMemory() - rt.totalMemory()) - RAM_LEAVE_FREE, MIN_RAM);
		log.info("Cache '{}' using a max {} MB of heap", this.name, MemoryUnit.MB.convert(maxHeap, MemoryUnit.B));
		
		if (inMemory) {
			initInMemory(tvClass, concurrency, maxHeap);
		} else {
			initWithCache(tvClass, concurrency, maxHeap);
		}
		clear();
	}
	
	private void initWithCache(Class<TV> tvClass, int concurrency, long maxHeap) {
		val path = SystemUtils.JAVA_IO_TMPDIR + this.name;
		log.info("Cache '{}' using path {}", this.name, path);
		
		long maxDisk;
		try {
			// Use 1/4th of the available disk space
			maxDisk = Files.getFileStore(Paths.get(".")).getUsableSpace() / 4;
		} catch (IOException e) {
			log.warn("Error detecting available disk space", e);
			maxDisk = MemoryUnit.B.convert(10L, MemoryUnit.GB);
		}
		log.info("Cache '{}' using a max {} GB of disk", this.name, MemoryUnit.GB.convert(maxDisk, MemoryUnit.B));
		
		// TODO: Use singleton manager and multiple caches?
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder().with(CacheManagerBuilder.persistence(path)).build(true);
		vectors = cacheManager.createCache(this.name, 
			CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, tvClass,	ResourcePoolsBuilder.newResourcePoolsBuilder()
	        		.heap(maxHeap, MemoryUnit.B)
		            .disk(maxDisk, MemoryUnit.B, false))
				.withDiskStoreThreadPool(this.name, concurrency)
		        .withSizeOfMaxObjectGraph(Long.MAX_VALUE)
		        .withService(CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(this, EventType.CREATED).build()));
		tokens = new TokenRegistry.TokenRegistryBig(this, concurrency);
	}
	
	private void initInMemory(Class<TV> tvClass, int concurrency, long maxHeap) {
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);
		vectors = cacheManager.createCache(this.name, 
			CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, tvClass,	ResourcePoolsBuilder.newResourcePoolsBuilder()
					.heap(maxHeap, MemoryUnit.B))
		        .withSizeOfMaxObjectGraph(Long.MAX_VALUE)
		        .withService(CacheEventListenerConfigurationBuilder.newEventListenerConfiguration(this, EventType.CREATED).build()));
		tokens = new TokenRegistry.TokenRegistrySmall();
	}
	
	@Override
	public void onEvent(CacheEvent<? extends Long, ? extends TV> event) {
		if (event.getType() == EventType.CREATED) { keys.add(event.getKey()); }
	}
	
	/**
	 * Clears the token vector set of all token vectors and removes all values
	 * from the token registry.
	 */
	public void clear() {
		tfidf = null;
		keys = new LongHashSet();
		tokens.clear();
		vectors.clear();
	}
	
	@Override
	public void close() {
		cacheManager.close();
	}
	
	/**
	 * Hash the token and register it with token vector set.
	 * @param string the token
	 * @return the token's uniquely identifying hash
	 */
	public long hash(String string) {
		return tokens.hash(string);
	}
	
	/**
	 * Returns the mappings of all token hashes to original tokens for this
	 * token vector. The same registry may be shared across multiple token
	 * vector instances.
	 * @return this token vector's token registry
	 */
	public TokenRegistry getTokens() { return tokens; }
	
	/**
	 * Adds a token vector to this token vector set with the specified key.
	 * @param <K> the key type
	 * @param key a key to uniquely identify the token vector
	 * @param tv the token vector
	 * @param keyHash the hasher that converts the key to a {@code long}
	 * @return if the token vector was added to the set. You cannot add more
	 * than one token vector with the same key hash.
	 */
	public <K> boolean add(K key, TV tv, DataHash<K> keyHash) {
		return add(keyHash.hash(key), tv);
	}

	private TV putIfAbsent(long key, TV tv) {
		tv.setKey(key);
		tv.mergeTokens(tokens);
		val ret = vectors.putIfAbsent(key, tv);
		// Pull newly added vector back into the memory tier
		if (ret == null) { vectors.get(key); }
		return ret;
	}
	
	/**
	 * Adds a token vector to this token vector set with the specified key.
	 * @param key a {@code long} to uniquely identify the token vector
	 * @param tv the token vector to add
	 * @return if the token vector was added to the set. You cannot add more
	 * than one token vector with the same key
	 */
	public boolean add(long key, TV tv) {
		return putIfAbsent(key, tv) == null;
	}
	
	/**
	 * Looks up a token vector by it's unique key.
	 * @param <K> the key type
	 * @param key a key to uniquely identify the token vector
	 * @param keyHash the hasher that converts the key to a {@code long}
	 * @return the token vector, or {@code null} if no token vector with that
	 * key was added to this token vector set
	 */
	public <K> TV get(K key, DataHash<K> keyHash) {
		return get(keyHash.hash(key));
	}
	
	/**
	 * Looks up a token vector by it's unique key.
	 * @param key the key
	 * @return the token vector, or {@code null} if no token vector with that
	 * key was added to this token vector set
	 */
	public TV get(long key) {
		return LambdaUtils.apply(vectors.get(key), tv -> {
			tv.init(tokens);
			return tv;
		});
	}
	
	public boolean update(long key, Consumer<TV> callback) {
		if (!contains(key)) { return false; }
		
		val tv = get(key);
		callback.accept(tv);
		vectors.put(key, tv);
		return true;
	}
	
	public TokenVectorSet<TV> mergeTokens(TokenRegistry reg) {
		reg.merge(tokens);
		tokens = reg;
		return this;
	}

	/**
	 * Remove the token vector associated with the key. 
	 * <strong>Warning:</strong> this does not update any computed weights or document counts; call it after or during
	 * calls to {@link #add(long, TokenVector)} or {@link #merge(long, TokenVector)} but before {@link #updateCounts(StatusMonitor)}
	 * or {@link #updateWeights(StatusMonitor, LongSet)}.
	 * @param key the key to remove if present
	 */
	public void remove(long key) {
		vectors.remove(key);
		keys.remove(key);
	}

	/**
	 * Adds or merges the token vector with the existing token vector in this set
	 * with the same key. This allows you to "accumulate" original counts with
	 * multiple token vectors for the same unique key.
	 * @param key a {@code long} to uniquely identify the token vector
	 * @param tv the token vector to add
	 * @see #merge(long, TokenVector, BiConsumer)
	 */
	public <S extends Serializable> void merge(long key, TV tv) {
		merge(key, tv, null);
	}
	
	/**
	 * Adds or merges the token vector with the existing token vector in this set
	 * with the same key. This allows you to "accumulate" original counts with
	 * multiple token vectors for the same unique key.
	 * @param key a {@code long} to uniquely identify the token vector
	 * @param tv the token vector to add
	 * @param customMerge any additional merge logic to perform when merging the token vector into the existing one 
	 * already in the set.
	 */
	public void merge(long key, TV tv, BiConsumer<TV, TV> customMerge) {
		TV existing = putIfAbsent(key, tv);
		if (existing == null) { return; }
		
		val origCounts = new LongIntHashMap(tv.countsRaw);
		boolean first = true;
		do {
			if (!first) {
				// Restore original counts so they don't get doubled
				origCounts.forEachKeyValue((t, c) -> tv.putCount(t, c));
				existing = vectors.get(key);
			}
			if (customMerge != null) {
				customMerge.accept(tv, existing);
			}
			existing.countsRaw.forEachKeyValue((t, c) -> {
				tv.putCount(t, tv.countsRaw.get(t) + c);
			});
			first = false;
		// Use this form of replace in case another thread merged in a vector for this key while we were doing the above
		// logic. If so, reject this merge and try again recursively using the updated existing vector
		} while (!vectors.replace(key, existing, tv));
	}
	
	/**
	 * Updates the overall counts in this token vector set after you are finished adding and merging documents.
	 * This updates the document frequency of each token and the total number of documents and tokens in this set. 
	 * @param sm to monitor/cancel the job (can be {@code null})
	 * @return this for method chaining
	 */
	public TokenVectorSet<TV> updateCounts(StatusMonitor sm) {
		if (sm != null) { sm.newTask("Updating counts...", size()); }
		
		// This is always called once callers are done adding/merging vectors into this set. The keys are added 
		// asynchronously via event listeners, so give a brief moment for the last keys to be added before iterating
		// through the whole set. TODO: Find a more reliable way of doing this
		Utilities.sleep(100L, TimeUnit.MILLISECONDS);
		
		tokens.compact();
		tfidf = new TokenVector();
		totalTokenCount = 0L;
		for (val tv : this) {
			if (sm != null) {
				if (!sm.isRunning()) { return this; }
				sm.setProgress(1L, true);
			}
			
			tv.countsRaw.forEachKeyValue((token, count) -> {
				tfidf.increment(token);
				totalTokenCount += count;
			});
		}
		return this;
	}
	
	/**
	 * Tests to see if this token vector set contains a token vector with the
	 * specified unique key. Unlike other data structures, this is much faster
	 * than testing a call to {@link #get(long)} since it avoids the
	 * persistent cache entirely.
	 * @param key the unique key
	 * @return if there is a token vector with the key in this set
	 */
	public boolean contains(long key) { return keys.contains(key); }
	
	/**
	 * Returns the number of token vectors in this set, including any cached vectors.
	 * @return the number of token vectors that have been added to this set
	 */
	public long size() { return keys.size(); }
	
	/**
	 * <p>Gets the inverse document frequency (IDF) weight of all tokens across
	 * all token vectors in this set.
	 * This equals log<sub><em>e</em></sub>(<em>d</em> / <em>d<sub>t</sub></em>), where d is the
	 * total number of documents and <em>d<sub>t</sub></em> is the number of documents containing at
	 * least one instance of token <em>t</em>.</p>
	 * <p><b>Note:</b> You must call {@link #updateWeights(StatusMonitor, LongSet)} before invoking this
	 * method. This is actual structure used to track counts/weights so
	 * do use any of the methods of {@code TokenVector} that modify it.</p>
	 * @return the token vector with the global token counts and weights for each
	 * token in this set
	 * @see TokenVector#getWeightedCount(long) Get a token's IDF weight
	 * @see TokenVector#getCount(long) Get a token's global count
	 */
	public TokenVector getTokenWeights() { return tfidf; }
	
	@Override
	public Iterator<TV> iterator() {
		val iter = keys.longIterator();
		return new Iterator<>() {
			@Override public boolean hasNext() { return iter.hasNext(); }
			@Override public TV next() { return get(iter.next()); }
			@Override public void remove() { throw new UnsupportedOperationException(); }
		};
	}
	
	/**
	 * Iterates through all pairwise combinations of token vectors in this set.
	 * @param uniqueOnly whether or not to include only unique pairs of token
	 * vectors. This will iterate over only the "upper triangle" of token vectors
	 * (when visualizing the token pairs as a {@code n} by {@code n} matrix).
	 * When this is {@code true}, the "diagonal" (pairs with equal token vectors)
	 * are also skipped.
	 * @return a new pairwise iterator
	 */
	public Iterator<Tuple2<TV, TV>> pairIterator(boolean uniqueOnly) {
		val keyArr = keys.toArray();
		return new TVSPairIterator<>(tokens, uniqueOnly, keyArr, vectors::get, keyArr, vectors::get);
	}
	
	/**
	 * Updates the weighted count of every token in each token vector in this set by combining the raw
	 * unweighted count with that token's weight in the provided vector.
	 * @param sm to monitor/cancel the job (can be {@code null})
	 * @param tokenFilter if specified, only the token hashes in this set will be kept and the weights set. All other
	 * tokens will be removed from each token vector.
	 * @param weights the weights to use
	 * @return this for method chaining
	 */
	public TokenVectorSet<TV> updateWeights(StatusMonitor sm, LongSet tokenFilter, TokenVector weights) {
		if (sm != null) { sm.newTask("Updating weights...", size()); }
		
		if (tokenFilter != null) {
			tokens.removeAll(tfidf.countsRaw.reject((token, c) -> tokenFilter.contains(token)).keySet());
			tfidf.countsRaw = tfidf.countsRaw.select((token, c) -> tokenFilter.contains(token));
			tfidf.countsWeighted = tfidf.countsWeighted.select((token, w) -> tokenFilter.contains(token));
		}

		for (val tv : this) {
			update(tv.getKey(), $ -> $.countsRaw = tv.countsRaw.select((token, count) -> {
				boolean keep = tokenFilter == null || tokenFilter.contains(token);
				if (keep) {
					float weight = weights.getWeightedCount(token);
					tv.countsWeighted.put(token, weight * count);	
				} else {
					tv.total -= count;
					totalTokenCount -= count;
					tv.countsWeighted.remove(token);
				}
				return keep;
			}));
			if (sm != null) {
				if (!sm.isRunning()) { return this; }
				sm.setProgress(1L, true);
			}
		}
		return this;
	}
	
	/**
	 * Computes the inverse document frequency of every token in this set and then updates the weighted count of
	 * every token in each token vector in this set with this weight.
	 * @param sm to monitor/cancel the job (can be {@code null})
	 * @param tokenFilter if specified, only the token hashes in this set will be kept and the weights set. All other
	 * tokens will be removed from each token vector.
	 * @see #updateWeights(StatusMonitor, LongSet, TokenVector) to use custom weights instead of the default TF-IDF
	 * @return this for method chaining
	 */
	public TokenVectorSet<TV> updateWeights(StatusMonitor sm, LongSet tokenFilter) {
		if (tfidf == null) { updateCounts(sm); }
		return updateWeights(sm, tokenFilter, InverseDocFreqCalculator.compute(size(), true, tfidf));
	}
	
	/**
	 * Computes the distances between the token vectors in this set and the token vectors in another set.
	 * One token vector set is the "query" set (when you want to find similar documents to those in
	 * the set) against a "corpus" set (the documents against which to query). This is more efficient then
	 * comparing the pairwise distances between token vectors in the corpus.
	 * @param other the other token vector set with which to compute distances
	 * @param settings the settings to configure the distance computation
	 * @return the distance results, or {@code null} if either token vector set is empty
	 */
	public TVSDistanceResults computeDistancesWith(TokenVectorSet<TV> other, TVSDistanceSettings settings) {
		val n = size();
		val m = other.size();
		if (n == 0L || m == 0L) { return null; }
		
		val idf = InverseDocFreqCalculator.compute(n + m, true, tfidf, other.tfidf);
		
		updateWeights(settings.getStatusMonitor(), null, idf);
		other.updateWeights(settings.getStatusMonitor(), null, idf);
		
		return DistanceCalculator.calculate(settings, n * m,
			new TVSPairIterator<>(tokens, false, keys.toArray(), vectors::get, other.keys.toArray(), other.vectors::get));
	}
	
	/**
	 * Computes the lowest set of distances between the token vectors in this set.
	 * <b>Note:</b> You must call {@link #updateWeights(StatusMonitor, LongSet)} prior to calling this method.
	 * @param settings the settings to configure the distance computation
	 * @return the sorted array of distances
	 */
	public TVSDistanceResults computeDistances(final TVSDistanceSettings settings) {
		val size = size();
		if (size < 2) { return null; }
		return DistanceCalculator.calculate(settings, (size * size - size) / 2L, pairIterator(true));
	}
	
	/**
	 * Removes all vectors whose count (total number of tokens) is outside the range specified. This can be used to 
	 * remove very short or very large documents from the corpus. This can especially be useful to remove documents
	 * that were originally longer but ended up with little or no tokens after stopwords and globally rare tokens
	 * were removed.
	 * @param sm the status monitor
	 * @param sizeRange the range of token vectors to keep. For example, if the minimum is {@code 5}, that means
	 * documents with 4 tokens (regardless of the distinct/uniqueness of those tokens) are removed.
	 * @return this for method chaining
	 * @see TokenVector#getTotal()
	 */
	public TokenVectorSet<TV> keepVectorsWithTotal(StatusMonitor sm, Range<Integer> sizeRange) {
		if (sm != null) { sm.newTask("Removing documents...", size()); }
		
		val toRemove = new LongHashSet();
		for (val tv : this) {
			if (!sizeRange.contains(tv.getTotal())) {
				toRemove.add(tv.getKey());
				vectors.remove(tv.getKey());
			}
			if (sm != null) {
				if (!sm.isRunning()) { return this; }
				sm.setProgress(1L, true);
			}
		}
		keys.removeAll(toRemove);
		return this;
	}
}
