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
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

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
@Builder
public class Documentation {
	private Supplier<String> nameProvider;
	/** A human-readable name for the component. */
	@Getter private String displayName;
	/** A longer description of the component. */
	@Getter private String description;
	/** The version of the component. */
	@Getter private String version;
	/** Tags (short keywords) that relate to the component. */
	@Getter private Set<String> tags;

	/** 
	 * The identifying name for the component. This is a {@link Supplier} since the documentation should not be the
	 * authority on assigning names to components, yet the name of a component is important piece of metadata for
	 * documenting it. This should generally be a method reference, like <tt>this::getName</tt>.
	 * @param nameProvider the name provider for the component.
	 * @return thew new instance that is a copy of this instance with the new name provider
	 */
	public Documentation withNameProvider(Supplier<String> nameProvider) {
		return new Documentation(nameProvider, displayName, description, version, tags);
	}
	
	public Documentation withDisplayName(String displayName) {
		return new Documentation(nameProvider, displayName, description, version, tags);
	}
	
	public Documentation withDescription(String description) {
		return new Documentation(nameProvider, displayName, description, version, tags);
	}
	
	public Documentation withVersion(String version) {
		return new Documentation(nameProvider, displayName, description, version, tags);
	}
	
	public Documentation withTags(Set<String> tags) {
		return new Documentation(nameProvider, displayName, description, version, tags);
	}
	
	/**
	 * The identifying name for this component.
	 * @return the component's name
	 */
	public String getName() { return LambdaUtils.get(nameProvider); }
	
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
	
	private static Documentation get(AnnotatedElement ae) {
		if (ae == null) { return null; }
		
		val db = Documentation.builder();
		Optional.ofNullable(ae.getAnnotation(DisplayName.class))
		        .map(DisplayName::value)
		        .ifPresent(db::displayName);
		Optional.ofNullable(ae.getAnnotation(Description.class))
		        .map(Description::value)
		        .ifPresent(db::description);
		Optional.ofNullable(ae.getAnnotation(Version.class))
		        .map(Version::value)
		        .ifPresent(db::version);
		Optional.ofNullable(ae.getAnnotation(Tags.class))
		        .map(Tags::value)
		        .ifPresent(tags -> {
		        	val set = new HashSet<String>();
		        	Collections.addAll(set, tags);
		        	db.tags(set);
		        });
		return db.build();
	}
	
	/**
	 * Sets the documentation from any present documentation annotations on the static fields in the class. The type
	 * of each annotated field must implement {@link HasDocumentation}.
	 * @param c the class whose fields to set
	 */
	public static void setFromAnnotations(Class<?> c) {
		setFromAnnotations(c, null);
	}
	
	/**
	 * Sets the documentation on an object from any present documentation annotations on the object's class and sets
	 * the documentation on its fields from annotations on those fields. The parameter object and its annotated fields
	 * must implement {@link HasDocumentation}.
	 * @param o the object to set
	 */
	public static void setFromAnnotations(Object o) {
		setFromAnnotations(o.getClass(), o);
	}
	
	private static void setFromAnnotations(Class<?> c, Object o) {
		if (o != null) { set(o, get(c)); }
		for (Field f : c.getFields()) {
			set(ReflectionUtils.get(f, o), get(f));
		}
	}
	
	private static void set(Object o, Documentation d) {
		if (o instanceof HasDocumentation) {
			HasDocumentation hd = Utilities.cast(o);
			hd.setDocumentation(d);
		}
	}
}
