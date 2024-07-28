/* ©2017-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.server;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>Parent class for dynamic key-value associative JSON objects. This is backed by an ordered map, but will not allow
 * any public getters/setters on the map class to reflect to JSON.</p>
 * <p>When extending this class, you are strongly encouraged to add a single {@code get}<i>Key</i> method that returns
 * type {@code V} (but always {@code null}), where <i>Key</i> is a description of the keys in the map. This will allow
 * callers to reflect the schema of the value type for documentation purposes.</p>
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <K> the key type (usually a JSON primitive type)
 * @param <V> the value type (any type that can be converted to JSON)
 * @since Mar 1, 2017
 */
public abstract class DynamicObject<K, V> extends LinkedHashMap<K, V> {
	@JsonIgnore @Override
	public boolean isEmpty() { return super.isEmpty(); }
}
