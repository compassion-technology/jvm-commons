package com.compassion.commons.jackson;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * When serializing POJOs as "placeholders" it's helpful to have nulls be empty
 * strings, ready to receive a real value later. For example, AWS Secrets Manager
 * rejects secret JSON with {@code null} values, but when initializing secret values
 * via CDK, the real secret often isn't available to the stack or managed externally.
 * Additionally, a "snake case" convention is more common outside of Java in CDK
 * contexts.
 */
public class PlaceholderMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public PlaceholderMapper() {
		setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		_serializerProvider.setNullValueSerializer(new NullAsEmptySerializer());
	}
	
	private static class NullAsEmptySerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			gen.writeString(StringUtils.EMPTY);
		}
	}
	
	public static final PlaceholderMapper INSTANCE = new PlaceholderMapper();
}
