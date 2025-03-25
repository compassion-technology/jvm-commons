package com.compassion.commons.extract;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * Provides a simplified way of specifying the locale "scope" of extract
 * operations.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 7, 2016
 */
public enum LocalityLevel {
	/** All locales available to the JVM. */
	ALL {
		@Override
		public List<Locale> getLocales(Locale[] all) {
			return Lists.newArrayList(all);
		}
	},
	/** All locales with the same language as the default locale's language. */
	LANGUAGE {
		@Override
		public List<Locale> getLocales(Locale[] all) {
			Locale defLocale = Locale.getDefault();
			String defLang = defLocale.getLanguage();
			
			List<Locale> ret = new LinkedList<>();
			// Ensure the default locale is first (and is tried first)
			ret.add(defLocale);
			for (Locale l : all) {
				if (!l.equals(defLocale) && StringUtils.equals(l.getLanguage(), defLang)) { ret.add(l); }
			}
			return ret;
		}
	},
	/** The default locale only. */
	LOCAL {
		@Override
		public List<Locale> getLocales(Locale[] all) {
			return Lists.newArrayList(Locale.getDefault());
		}
	};
	
	/**
	 * Gets the locales that match this locality level.
	 * @param all the list of all available locales
	 * @return the list of matching locales
	 */
	public abstract List<Locale> getLocales(Locale[] all);
}
