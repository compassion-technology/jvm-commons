package com.compassion.commons.jooq;

import org.apache.commons.lang3.StringUtils;
import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

/**
 * Removes pluralization of table names when creating class names as well as using "Row" for records and "Raw" for POJOs.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Oct 19, 2016
 */
public class ERIGeneratorStrategy extends DefaultGeneratorStrategy {
	@Override
	public String getJavaClassName(Definition definition, Mode mode) {
		String ret = super.getJavaClassName(definition, mode);
		switch (mode) {
			case DEFAULT:   return ret + "Table";
			case RECORD:    return singularize(StringUtils.removeEnd(ret, "Record")) + "Row";
			case POJO:      return singularize(ret) + "Raw";
			case INTERFACE: return singularize(ret);
			default:        return ret;
		}
	}
	
	private static String singularize(String s) {
		if (StringUtils.endsWith(s, "ies")) {
			return StringUtils.removeEnd(s, "ies") + "y";
		}
		if (StringUtils.endsWith(s, "ses")) {
			return StringUtils.removeEnd(s, "es");
		}
		if (StringUtils.endsWith(s, "s")) {
			return StringUtils.chop(s);
		}
		return s;
	}
}
