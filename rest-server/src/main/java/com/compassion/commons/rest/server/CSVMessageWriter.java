package com.compassion.commons.rest.server;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

import com.compassion.commons.Utilities;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import lombok.val;

@Provider
@Produces({RestResource.APPLICATION_CSV, RestResource.TEXT_CSV})
public class CSVMessageWriter<T> implements MessageBodyWriter<Collection<T>> {
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Collection.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Collection<T> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return 0L;
	}

	@Override
	public void writeTo(Collection<T> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		if (t != null && t.size() > 0) {
			val first  = Utilities.first(t);
			val mapper = new CsvMapper();
			val schema = mapper.schemaFor(first.getClass());
	        mapper.writer(schema.withHeader()).writeValue(entityStream, t);	
		}
	}
}
