package com.compassion.commons.pulsar.mock;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.pulsar.functions.api.Record;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data @Accessors(chain = true)
public class MockRecord implements Record<Object> {
	private Optional<String>
		destinationTopic = Optional.empty(),
		topicName = Optional.empty(),
		key = Optional.empty();
	
	private Object value;
	
	private Map<String, String> properties = new HashMap<>();

	@JsonProperty("eventTime")
	private Optional<Date> eventDate = Optional.of(new Date());
	
	@Override @JsonIgnore
	public Optional<Long> getEventTime() {
		return eventDate.map($ -> $.getTime());
	}
}
