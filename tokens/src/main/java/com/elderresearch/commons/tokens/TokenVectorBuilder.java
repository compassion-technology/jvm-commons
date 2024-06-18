/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.tokens;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import com.elderresearch.commons.hash.HashUtils;

import lombok.val;
import lombok.extern.log4j.Log4j2;

/**
 * This class accepts character input, tokenizes it using Lucene, and produces
 * {@link TokenVector} instances.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jul 2, 2013
 */
@Log4j2
public class TokenVectorBuilder {
	private int minLength = 1;
	private long[] blacklist;
	private List<TokenizerListener> listeners = new ArrayList<>();
	private Supplier<TokenVector> factory = TokenVector::new;
	private Function<String, String> transformer;
	private ThreadLocal<Tokenizer> tokenizer = ThreadLocal.withInitial(StandardTokenizer::new);
	
	/**
	 * Sets the factory to instantiate blank token vectors, to allow for subclasses.
	 * @param factory the factory that creates {@link TokenVector} instances. This default is the default constructor
	 * {@link TokenVector#TokenVector()}.
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setFactory(Supplier<TokenVector> factory) {
		this.factory = factory;
		return this;
	}
	
	/**
	 * Sets the minimum length of allowed tokens in this token vector builder.
	 * For example, if this is {@code 2}, one letter tokens will not be included.
	 * @param minLength the minimum token length (defaults to {@code 1})
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setMinLength(int minLength) {
		this.minLength = minLength;
		return this;
	}
	
	/**
	 * "Blacklists" the tokens and prevents them from being added to any token
	 * vectors this builder builds. This is useful for preventing stopwords like
	 * "a", "the", "I", etc. from being considered valid tokens and diluting
	 * token vectors.
	 * @param tokens one or more tokens to blacklist
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setBlacklist(String... tokens) {
		long[] hashes = new long[tokens.length];
		for (int i = 0; i < tokens.length; i++) {
			hashes[i] = HashUtils.getCRC64(tokens[i]);
		}
		return setBlacklist(hashes);
	}
	
	/**
	 * "Blacklists" the token hashes and prevents them from being added to any token
	 * vectors this builder builds. This is useful for preventing stopwords like
	 * "a", "the", "I", etc. from being considered valid tokens and diluting
	 * token vectors.
	 * @param tokenHashes one or more tokens to blacklist
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setBlacklist(long... tokenHashes) {
		this.blacklist = tokenHashes;
		return this;
	}
	
	/**
	 * Sets the tokenizer that determines how tokens are created for this builder.
	 * @param tokenizer the thread-safe Lucene tokenizer (defaults to instances
	 * of {@link StandardTokenizer})
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setTokenizer(ThreadLocal<Tokenizer> tokenizer) {
		this.tokenizer = tokenizer;
		return this;
	}
	
	/**
	 * Sets the transformer for each token before it is added to the token vector.
	 * A common use case would be to use {@code String::toLowerCase} as the 
	 * transformer to make this builder case-insensitive even if the tokenizer
	 * is not. If the transformer returns {@code null}, the token will be skipped.
	 * <b>Note:</b> This transformer <b>must</b> be thread-safe.
	 * @param transformer the token transformer (can be {@code null})
	 * @return this for method chaining
	 */
	public TokenVectorBuilder setTransformer(Function<String, String> transformer) {
		this.transformer = transformer;
		return this;
	}
	
	/**
	 * Adds a listener that will be notified during {@link #build(Reader) building}
	 * as each token is encountered.
	 * @param listener a listener
	 * @return this for method chaining
	 */
	public TokenVectorBuilder addListener(TokenizerListener listener) {
		listeners.add(listener);
		return this;
	}
	
	/**
	 * Builds a new token vector using the input text.
	 * @param input the document or text
	 * @return a new token vector, or {@code null} if there was a problem
	 * building the vector
	 */
	public TokenVector build(String input) {
		try (val sr = new StringReader(input)) {
			return build(sr);
		}
	}
	
	/**
	 * Builds a new token vector using the input reader.
	 * @param input the reader. This reader is <b>not</b> automatically closed
	 * by this method.
	 * @return a new token vector, which may be empty if there was a problem
	 * building the vector
	 */
	public TokenVector build(Reader input) {
		val ret = factory.get();
		merge(ret, input);
		return ret;
	}
	
	/**
	 * Fills an existing token vector by incrementing the counts of each token contained in the input.
	 * @param tv the existing token vector
	 * @param input the document or text
	 * @return this for method chaining
	 */
	public TokenVectorBuilder merge(TokenVector tv, String input) {
		try (val sr = new StringReader(input)) {
			return merge(tv, sr);
		}
	}
	
	/**
	 * Fills an existing token vector by incrementing the counts of each token contained in the input.
	 * @param tv the existing token vector
	 * @param input the reader. This reader is <b>not</b> automatically closed
	 * by this method.
	 * @return this for method chaining
	 */
	public TokenVectorBuilder merge(TokenVector tv, Reader input) {
		try (val t = tokenizer.get()) {
			t.setReader(input);
			t.reset();
			
			CharTermAttribute cta = t.addAttribute(CharTermAttribute.class);
			OffsetAttribute oa = t.addAttribute(OffsetAttribute.class);
			
			out: while (t.incrementToken()) {
				if (cta.length() < minLength) { continue; }
				
				String token = cta.toString();
				int    start = oa.startOffset();
				int    end   = oa.endOffset();
				
				if (transformer != null) {
					token = transformer.apply(token);
					if (token == null) { continue; }
				}
				
				tv.increment(token);
				
				for (TokenizerListener listener : listeners) {
					if (!listener.process(token, start, end)) { break out; }
				}
			}
		} catch (IOException ex) {
			log.warn("Error during tokenization", ex);
			return this;
		}
		
		if (blacklist != null) {
			for (val hash : blacklist) {
				tv.countsRaw.remove(hash);
				tv.countsWeighted.remove(hash);
			}
		}
		return this;
	}
	
	/**
	 * Optional listener if the caller would like to be notified after each
	 * token is encountered.
	 */
	public interface TokenizerListener {
		/**
		 * This method is invoked as each token is encountered.
		 * @param token the token
		 * @param start the start position in the original input (inclusive)
		 * @param end the end position in the original input (exlusive)
		 * @return if the tokenizer should continue. Return {@code false} to
		 * prematurely abort tokenization, but note that the token vector may
		 * not be in a usable or valid state
		 * @see CharTermAttribute#toString()
		 * @see OffsetAttribute#startOffset()
		 * @see OffsetAttribute#endOffset()
		 */
		boolean process(String token, int start, int end);
	}
}
