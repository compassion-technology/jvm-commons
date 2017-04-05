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
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.val;

/**
 * A way of documenting a component (via annotations or by providing a {@link Documentation} bean) that is readable at
 * run time. This class uses {@link CharSequence} instead of {@link String} so that the values can be customized
 * dynamically (for example localized).
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 1, 2017
 */
@Builder
public class Documentation {
	private Supplier<CharSequence> nameProvider;
	/** The type of the component. */
	@Getter private Class<?> type;
	/** A human-readable name for the component. */
	@Getter private CharSequence displayName;
	/** A longer description of the component. */
	@Getter private CharSequence description;
	/** The version of the component. */
	@Getter private CharSequence version;
	/** Tags (short keywords) that relate to the component. */
	@Getter private Set<CharSequence> tags;
	/** Lists requirements for this component. */
	@Getter private List<Documentation> requires;
	/** Lists the output this component produces. */
	@Getter private List<Documentation> produces;

	/** 
	 * The identifying name for the component. This is a {@link Supplier} since the documentation should not be the
	 * authority on assigning names to components, yet the name of a component is important piece of metadata for
	 * documenting it. This should generally be a method reference, like <tt>this::getName</tt>.
	 * @param nameProvider the name provider for the component.
	 * @return thew new instance that is a copy of this instance with the new name provider
	 */
	public Documentation withNameProvider(Supplier<CharSequence> nameProvider) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withType(Class<?> type) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withDisplayName(CharSequence displayName) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withDescription(CharSequence description) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withVersion(CharSequence version) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withTags(Set<CharSequence> tags) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withRequires(List<Documentation> requires) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	public Documentation withProduces(List<Documentation> produces) {
		return new Documentation(nameProvider, type, displayName, description, version, tags, requires, produces);
	}
	
	/**
	 * The identifying name for this component.
	 * @return the component's name
	 */
	public CharSequence getName() { return LambdaUtils.get(nameProvider); }
	
	/** A description of the requirements (or prerequisites or input) of this component. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Requires {
		Doc[] value();
	}
	
	/** A description of what this component produces (or output). */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Produces {
		Doc[] value();
	}
	
	/** A "parent" annotation for all documentation-related annotations. */
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Doc {
		/** The type of the component. */
		Class<?> type() default Object.class;
		/** The way to identify a component. */
		String name() default StringUtils.EMPTY;
		/** A human-readable name for the component. */
		String displayName() default StringUtils.EMPTY;
		/** A longer description of a component. */
		String value() default StringUtils.EMPTY;
		/** The version of the component. */
		String version() default StringUtils.EMPTY;
		/** Tags (short keywords) that relate to the component. */
		String[] tags() default {};
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
	
	private static void ifNotEmpty(String s, Consumer<String> c) {
		if (StringUtils.isNotEmpty(s)) { c.accept(s); }
	}
	
	private static Documentation get(AnnotatedElement ae) {
		if (ae == null) { return null; }
		
		val db = Documentation.builder();
		Optional.ofNullable(ae.getAnnotation(Doc.class)).ifPresent(d -> DOC_ADAPTER.accept(d, db));
		Optional.ofNullable(ae.getAnnotation(Requires.class)).ifPresent(r -> db.requires(DOC_LIST_ADAPTER.apply(r.value())));
		Optional.ofNullable(ae.getAnnotation(Produces.class)).ifPresent(r -> db.produces(DOC_LIST_ADAPTER.apply(r.value())));
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
	
	private static final BiConsumer<Doc, Documentation.DocumentationBuilder> DOC_ADAPTER = (d, db) -> {
		if (d.type() != Object.class) { db.type(d.type()); }
		ifNotEmpty(d.name(), n -> db.nameProvider(() -> n));
		ifNotEmpty(d.displayName(), db::displayName);
		ifNotEmpty(d.value(), db::description);
		ifNotEmpty(d.version(), db::version);
		if (ArrayUtils.getLength(d.tags()) > 0) {
			val set = new HashSet<CharSequence>();
        	Collections.addAll(set, d.tags());
        	db.tags(set);
		}
	};
	
	private static final Function<Doc[], List<Documentation>> DOC_LIST_ADAPTER = arr -> {
		val ret = new LinkedList<Documentation>();
		for (val d : arr) {
			val db = Documentation.builder();
			DOC_ADAPTER.accept(d, db);
			ret.add(db.build());
		}
		return ret;
	};
}
