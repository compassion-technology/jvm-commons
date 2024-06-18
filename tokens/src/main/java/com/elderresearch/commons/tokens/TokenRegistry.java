/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.util.Iterator;

import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.ehcache.Cache;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

import com.compassion.commons.ThreadLocalList;
import com.elderresearch.commons.hash.HashUtils;

import lombok.val;

public abstract class TokenRegistry {
	// TODO: Fixed sixe of 200 MB per token registry means potential memory pressure if many large corpora are loaded
	private static final long MAX_RAM_MB = 200;
	// TODO: Don't know if the user has 4 GB of free disk space... 4 GB should encompass unique tokens from huge corpora
	private static final long MAX_DISK_GB = 4;
	
	public abstract TokenVectorSet<?> getCorpus();
	
	public long hash(String token) {
		long hash = HashUtils.getCRC64(token);
		put(hash, token);
		return hash;
	}
	
	/**
	 * Gets the string corresponding to the provided hash.  Token vectors map hashes to counts
	 * for performance reasons, so this provides the mechanism for accessing the original tokens.
	 * @param tokenHash the hash code of a token 
	 * @return the original token, or {@code null} if the hash is not present in any of the token
	 * vectors that have been added to this token vector set
	 */
	public abstract String get(long tokenHash);
	
	public abstract Iterator<Cache.Entry<Long, String>> iterator();
	
	abstract void clear();
	abstract void compact();
	abstract void put(long hash, String token);
	abstract void remove(long tokenHash);
	abstract void removeAll(LongSet hashes);
	
	void merge(TokenRegistry other) {
		other.iterator().forEachRemaining(e -> put(e.getKey(), e.getValue()));
	}
	
	// Small, in-memory registry as token vectors are being built
	static class TokenRegistrySmall extends TokenRegistry {
		private LongObjectHashMap<String> registry = new LongObjectHashMap<>();
		
		@Override
		public String get(long tokenHash) { return registry.get(tokenHash); }
		
		@Override
		public TokenVectorSet<?> getCorpus() { return null; }
		
		@Override
		void clear() { registry.clear(); }
		
		@Override
		void compact() { registry.compact(); }
		
		@Override
		void put(long hash, String token) { registry.put(hash, token); }
		
		@Override
		void remove(long tokenHash) { registry.remove(tokenHash); }
		
		@Override
		void removeAll(LongSet hashes) { hashes.forEach(registry::remove); }	
		
		@Override
		public Iterator<Cache.Entry<Long, String>> iterator() {
			val iter = registry.keyValuesView().iterator();
			return new Iterator<>() {
				@Override public boolean hasNext() { return iter.hasNext(); }
				@Override public void remove() { iter.remove(); }
				@Override public Cache.Entry<Long, String> next() {
					LongObjectPair<String> pair = iter.next();
					return new Cache.Entry<>() {
						@Override public Long getKey() { return pair.getOne(); }
						@Override public String getValue() { return pair.getTwo(); }
					};
				}
			};
		}
	}
	
	// Ehcache-backed token registries for entire corpora that spills to disk
	static class TokenRegistryBig extends TokenRegistry {
		private TokenVectorSet<?> tvs;
		private Cache<Long, String> registry;
		
		// Too much contention on putIfAbsent. Use a simple key set that doesn't need to be synchronized - it's OK
		// if a thread tries to add a token again that another thread already handled. Ehcache will resolve that. This
		// just greatly minimizes calls to the underlying cache.
		private ThreadLocalList<LongHashSet> keyCache = new ThreadLocalList<>(LongHashSet::new);
		
		TokenRegistryBig(TokenVectorSet<?> tvs, int concurrency) {
			this.tvs = tvs;
			registry = tvs.getCacheManager().createCache(tvs.getName() + "-tokens", 
				CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
		        	ResourcePoolsBuilder.newResourcePoolsBuilder()
		        		.heap(MAX_RAM_MB, MemoryUnit.MB)
			            .disk(MAX_DISK_GB, MemoryUnit.GB, false))
					.withDiskStoreThreadPool(tvs.getName() + "-tokens", concurrency)
			        .withSizeOfMaxObjectGraph(Long.MAX_VALUE));
		}
		
		@Override
		public TokenVectorSet<?> getCorpus() { return tvs; }
		
		@Override
		public String get(long tokenHash) { return registry.get(tokenHash); }
		
		@Override
		void clear() { registry.clear(); }
		
		@Override
		void compact() {
			keyCache.forEach(set -> {
				set.clear();
				set.compact();
			});
		}
		
		@Override
		void put(long hash, String token) {
			if (keyCache.get().add(hash)) {
	            registry.putIfAbsent(hash, token);
			}
		}
		
		@Override
		void remove(long tokenHash) {
			// NOOP: Big token registries keep all tokens in the registry so the value of token hash is never "lost" for
			// a corpus. Only small registries remove hashes from their in-memory maps...
		}
		
		@Override
		void removeAll(LongSet hashes) {
			// ... unless the corpus is doing clean up and does want to remove the token from all vectors and registries
			hashes.forEach(this::remove);
		}
		
		@Override
		public Iterator<Cache.Entry<Long, String>> iterator() { return registry.iterator(); }
	}
}
