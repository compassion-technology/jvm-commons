package com.compassion.commons.aws;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import software.amazon.awssdk.regions.Region;

/**
 * AWS regions serialize as POJOs by default so this class provides Jackson/JSON serialization using the region ID.
 */
public interface RegionSerde {
    class Deserializer extends StdDeserializer<Region> {
		private static final long serialVersionUID = 1L;

		public Deserializer() { super(Region.class); }

		@Override
    	public Region deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
    		return Region.of(p.getValueAsString());
    	}
    }
    
    class Serializer extends StdSerializer<Region> {
		private static final long serialVersionUID = 1L;

		public Serializer() { super(Region.class); }
    	
    	@Override
    	public void serialize(Region value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    		gen.writeString(value.id());
    	}
    }
}
