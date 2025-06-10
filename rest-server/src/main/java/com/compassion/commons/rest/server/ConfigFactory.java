package com.compassion.commons.rest.server;

import java.io.IOException;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.compassion.commons.config.Config;
import com.compassion.commons.config.ConfigOverrides;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.DefaultConfigurationFactoryFactory;
import io.dropwizard.configuration.YamlConfigurationFactory;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

/**
 * Bridge Compassion commons config framework and Dropwizard config.
 * @param <C> the configuration implementation class
 */
@Log4j2
@Accessors(chain = true)
public class ConfigFactory<C extends Config> extends YamlConfigurationFactory<C> {
	private final String prefix;
	
	@Setter
	private ObjectMapper loggingMapper = new YAMLMapper().findAndRegisterModules();
	@Setter
	private UnaryOperator<ConfigOverrides> overrides = $ -> $.withEnvironmentVariables().withSystemProperties();
	
	public ConfigFactory(Class<C> klass, @Nullable Validator validator, ObjectMapper objectMapper,
			String propertyPrefix) {
		super(klass, validator, objectMapper, propertyPrefix);
		this.prefix = propertyPrefix;
	}

	@Override
	public C build(ConfigurationSourceProvider provider, String path) throws IOException, ConfigurationException {
		var ret = super.build(provider, path);
		ret = Config.load(log, mapper, ret, overrides.apply(ConfigOverrides.forPrefixes(prefix)));
		if (loggingMapper != null) {
			ret.logConfig(loggingMapper);
		}
		return ret;
	}
	
	@RequiredArgsConstructor
	public static class ConfigFactoryFactory<T extends Config> extends DefaultConfigurationFactoryFactory<T> {
		private final String prefix;
		
		@Override
		public ConfigurationFactory<T> create(Class<T> klass, Validator validator, ObjectMapper mapper, String dwPrefix) {
			return new ConfigFactory<>(klass, validator, configureObjectMapper(mapper), StringUtils.defaultIfBlank(prefix, dwPrefix));
		}
	}
}
