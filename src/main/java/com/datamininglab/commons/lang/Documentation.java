/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.val;

/**
 * A way of documenting a component (via annotations or by providing a {@link Documentation} bean) that is readable at
 * run time.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 1, 2017
 */
@Getter @Builder
public class Documentation {
	/** A human-readable name for the component. */
	private String displayName;
	/** A longer description of the component. */
	private String description;
	/** The version of the component. */
	private String version;
	/** Tags (short keywords) that relate to the component. */
	private Set<String> tags;
	
	public Documentation withDisplayName(String displayName) {
		return new Documentation(displayName, description, version, tags);
	}
	
	public Documentation withDescription(String description) {
		return new Documentation(displayName, description, version, tags);
	}
	
	public Documentation withVersion(String version) {
		return new Documentation(displayName, description, version, tags);
	}
	
	public Documentation withTags(Set<String> tags) {
		return new Documentation(displayName, description, version, tags);
	}
	
	/** A longer description of a component. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Description {
		String value();
	}

	/** The way to identify a component. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface DisplayName {
		String value();
	}
	
	/** A human-readable name for the component. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Version {
		String value();
	}
	
	/** Tags (short keywords) that relate to the component. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Tags {
		String[] value();
	}
	
	/**
	 * Indicates a component supports documentation. The default implementation looks for documentation annotations
	 * on the implementing type to return the {@link Documentation} instance, so you do not have to do anything to
	 * implement this interface if you are planning on using annotations. If your class will hold a reference to a
	 * documentation instance, consider implementing {@link HasDocumentation} as well.
	 */
	public interface IsDocumented {
		/**
		 * Provides documentation for this component (like its name and a description of what it does). The default
		 * implementation inspects any documentation annotations on this type to derive the returned documentation.
		 * @return the documentation for this component (should not be <tt>null</tt>)
		 */
		default Documentation getDocumentation() {
			return Documentation.get(getClass());
		}
	}
	
	/**
	 * Indicates a component provides documentation as well as allowing callers to change the documentation at runtime.
	 * To support either way of using documentation (either programmatically at runtime or via annotations) implementations
	 * should generally use the default implementation of {@link #getDocumentation()} to set the initial documentation
	 * instance:<p><code>setDocumentation(HasDocumentation.super.getDocumentation());</code></p> This will derive the
	 * initial documentation from any present annotations, but also allow subsequent callers to customize it via
	 * {@link #setDocumentation(Documentation)}.
	 */
	public interface HasDocumentation extends IsDocumented {
		/**
		 * Sets the documentation for this component (like its name and a description of what it does).
		 * @param d the new documentation
		 */
		void setDocumentation(Documentation d);
	}
	
	public static void setFromAnnotations(Object o) {
		if (o == null) { return; }
		
		update(o, get(o.getClass()));
		for (Field f : o.getClass().getFields()) {
			update(ReflectionUtils.get(f, o), get(f));
		}
	}
	
	private static Documentation get(AnnotatedElement ae) {
		if (ae == null) { return null; }
		
		val db = Documentation.builder();
		db.displayName(LambdaUtils.apply(ae.getAnnotation(DisplayName.class), DisplayName::value));
		db.description(LambdaUtils.apply(ae.getAnnotation(Description.class), Description::value));
		db.version(LambdaUtils.apply(ae.getAnnotation(Version.class), Version::value));
		
		val tags = new HashSet<String>();
		LambdaUtils.accept(ae.getAnnotation(Tags.class), a -> Collections.addAll(tags, a.value()));
		db.tags(tags);
		
		return db.build();
	}
	
	private static void update(Object o, Documentation d) {
		if (o instanceof HasDocumentation) {
			HasDocumentation hd = Utilities.cast(o);
			hd.setDocumentation(d);
		}
	}
}
