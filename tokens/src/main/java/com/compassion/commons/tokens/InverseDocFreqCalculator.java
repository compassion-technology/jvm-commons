package com.compassion.commons.tokens;

import java.util.Arrays;

import com.compassion.commons.Utilities;

import lombok.val;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InverseDocFreqCalculator {
	/**
	 * Computes the inverse document weights for each token and sets the weighted counts on the specified token vectors.
	 * @param docs the total number of docs in the corpus
	 * @param log whether to log-scale the ratio of the document count to the total doc count
	 * @param docFreqs the document frequency of each token in the corpus. If more than one token vector is specified,
	 * the counts for a given document ID will be summed across all token vectors.
	 * @return the overall token count and weight vector
	 */
	public TokenVector compute(long docs, boolean log, TokenVector... docFreqs) {
		if (docFreqs.length == 0) {
			throw new IllegalArgumentException("You must specify at least one document frequency vector");
		}
		
		val in = Arrays.asList(docFreqs);
		
		// Sum up all counts into a new vector
		val total = new TokenVector();
		in.forEach(tv -> tv.countsRaw.forEachKeyValue(total.countsRaw::addToValue));
		
		// Compute the weights (doc count / total docs)
		total.countsRaw.forEachKeyValue((k, count) -> {
			double weight = docs / (double) count;
			if (log) { weight = Math.log(weight); }
			total.countsWeighted.put(k, (float) weight);
		});
		
		// Apply the weight back to each vector
		if (docFreqs.length == 1) {
			// Optimization - the only keys in the total vector are those in the single input
			Utilities.first(docFreqs).countsWeighted.putAll(total.countsWeighted);
		} else {
			// Otherwise, filter the weights to only those present in each input
			in.forEach(tv -> tv.countsWeighted.putAll(total.countsWeighted.select((k, $) -> tv.countsRaw.containsKey(k))));
		}
		
		// Return the overall vector
		return total;
	}
}
