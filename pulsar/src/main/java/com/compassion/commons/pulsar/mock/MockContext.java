package com.compassion.commons.pulsar.mock;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.apache.pulsar.client.admin.PulsarAdmin;
import org.apache.pulsar.client.api.ConsumerBuilder;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.TypedMessageBuilder;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Record;
import org.apache.pulsar.functions.api.StateStore;
import org.apache.pulsar.functions.api.utils.FunctionRecord.FunctionRecordBuilder;
import org.slf4j.Logger;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MockContext implements Context {
	private final String environment;
	private final Map<String, Object> config;
	private final Map<String, String> secrets = new HashMap<>();
	
	public MockContext() {
		this("devint", Collections.emptyMap());
	}
	
	@Setter
	private Record<?> record = new MockRecord();
	
	@Override
	public Object getUserConfigValueOrDefault(String key, Object defaultValue) {
		return getUserConfigValue(key).orElse(defaultValue);
	}
	
	@Override
	public Optional<Object> getUserConfigValue(String key) {
		return Optional.ofNullable(config.get(key));
	}
	
	public MockContext putSecret(String secretName, String secret) {
		secrets.put(secretName, secret);
		return this;
	}
	
	@Override public Record<?> getCurrentRecord() { return record; }
	@Override public void recordMetric(String metricName, double value) { /* No impl */ }
	@Override public CompletableFuture<Void> putStateAsync(String key, ByteBuffer value) { return null; }
	@Override public void putState(String key, ByteBuffer value) { /* No impl */ }
	@Override public <O> CompletableFuture<Void> publish(String topicName, O object, String schemaOrSerdeClassName) { return null; }
	@Override public <O> CompletableFuture<Void> publish(String topicName, O object) { return null; }
	@Override public <O> TypedMessageBuilder<O> newOutputMessage(String topicName, Schema<O> schema) throws PulsarClientException { return null; }
	@Override public <O> ConsumerBuilder<O> newConsumerBuilder(Schema<O> schema) throws PulsarClientException { return null; }
	@Override public CompletableFuture<Void> incrCounterAsync(String key, long amount) { return null; }
	@Override public void incrCounter(String key, long amount) { /* No impl */ }
	@Override public Map<String, Object> getUserConfigMap() { return config; }
	@Override public String getTenant() { return "supporter"; }
	@Override public <S extends StateStore> S getStateStore(String tenant, String ns, String name) { return null; }
	@Override public <S extends StateStore> S getStateStore(String name) { return null; }
	@Override public CompletableFuture<ByteBuffer> getStateAsync(String key) { return null; }
	@Override public ByteBuffer getState(String key) { return null; }
	@Override public String getSecret(String secretName) { return secrets.get(secretName); }
	@Override public String getOutputTopic() { return null; }
	@Override public String getOutputSchemaType() { return null; }
	@Override public int getNumInstances() { return 0; }
	@Override public String getNamespace() { return environment + "-retain"; }
	@Override public Logger getLogger() { return log; }
	@Override public int getInstanceId() { return 0; }
	@Override public Collection<String> getInputTopics() { return null; }
	@Override public String getFunctionVersion() { return null; }
	@Override public String getFunctionName() { return null; }
	@Override public String getFunctionId() { return null; }
	@Override public CompletableFuture<Long> getCounterAsync(String key) { return null; }
	@Override public long getCounter(String key) { return 0; }
	@Override public CompletableFuture<Void> deleteStateAsync(String key) { return null; }
	@Override public void deleteState(String key) { /* No impl */ }
	@Override public PulsarAdmin getPulsarAdmin() { return null; }
	@Override public <X> FunctionRecordBuilder<X> newOutputRecordBuilder(Schema<X> schema) { return null; }
}
