package com.compassion.commons.pulsar;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.ClientCnx;
import org.apache.pulsar.common.api.proto.MessageMetadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.Module;

public interface PulsarJacksonUtils {
	interface RecordMixin<T> {
		@JsonIgnore
		Optional<Message<T>> getMessage();
	}

	interface MessageMixin<T> {
		@JsonIgnore
	    MessageMetadata getMessageBuilder();
		@JsonIgnore
	    Optional<Schema<?>> getReaderSchema();
		@JsonIgnore
		ClientCnx getCnx();
		@JsonSerialize(using = ByeToMapSerializer.class)
		byte[] getData();
	}
	
	static ObjectMapper initMapper(ObjectMapper om, Module...  modules) {
		return om
		  .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
		  .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		  .addMixIn(Record.class, RecordMixin.class)
		  .addMixIn(Message.class, MessageMixin.class)
		  .registerModules(modules);
	}
	
	class ByeToMapSerializer extends StdSerializer<byte[]> {
		private static final long serialVersionUID = 1L;
		
		private static final ObjectMapper mapper = initMapper(new ObjectMapper(),
			new Jdk8Module(), new JavaTimeModule());

		public ByeToMapSerializer() { super(byte[].class); }
		
		@Override
		public void serialize(byte[] value, JsonGenerator gen, SerializerProvider provider) throws IOException {
			gen.writeObject(mapper.readValue(value, Map.class));
		}
	}
}
