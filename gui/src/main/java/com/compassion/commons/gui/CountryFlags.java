package com.compassion.commons.gui;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.compassion.commons.ReflectionUtils;
import com.compassion.commons.gui.icons.IconsERI;
import com.compassion.commons.gui.icons.IconsFlags;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class CountryFlags {
	/**
	 * Get the flag icon with the given country name. The parameter name must
	 * match one of the flag constant names in {@link IconsFlags} (ignoring
	 * punctuation, capitalization, and spacing).
	 * @param countryName the name of the country
	 * @return the flag icon, or {@code null} if {@code countryName} is {@code null}
	 * or {@link IconsERI#FLAG_UNKNOWN} doesn't match any countries.
	 */
	public String getFlagIcon(String countryName) {
		if (countryName == null) { return null; }

		countryName = "FLAG_" + countryName.toUpperCase().replaceAll("[^A-Z]+", "_");
		Field f = FieldUtils.getField(IconsFlags.class, countryName);
		if (f == null) { return IconsERI.FLAG_UNKNOWN; }

		return ReflectionUtils.get(f, null).toString();
	}
}
