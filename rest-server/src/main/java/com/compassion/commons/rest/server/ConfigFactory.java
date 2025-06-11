package com.compassion.commons.rest.server;

import java.io.IOException;
import java.util.function.BiFunction;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.compassion.commons.Utilities;
import com.compassion.commons.config.Config;
import com.compassion.commons.config.ConfigOverrides;
import com.compassion.commons.config.ParamStoreEnvironment.ParamStoreAwareConfig;
import com.compassion.commons.config.ReplaceSecretsTree;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.DefaultConfigurationFactoryFactory;
import io.dropwizard.configuration.YamlConfigurationFactory;
import jakarta.validation.Validator;
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
	private BiFunction<C, ConfigOverrides, ConfigOverrides> overrides;
	
	public ConfigFactory(Class<C> klass, @Nullable Validator validator, ObjectMapper objectMapper,
			String propertyPrefix) {
		super(klass, validator, objectMapper, propertyPrefix);
		this.prefix = propertyPrefix;
		this.overrides = (config, $) -> ReplaceSecretsTree.envVarsSysProps(prefix);
	}

	@Override
	public C build(ConfigurationSourceProvider provider, String path) throws IOException, ConfigurationException {
		var ret = super.build(provider, path);
		ret = Config.load(log, mapper, ret, overrides.apply(ret, ConfigOverrides.forPrefixes(prefix)));
		if (loggingMapper != null) {
			ret.logConfig(loggingMapper);
		}
		return ret;
	}
	
	public static class ConfigFactoryFactory<T extends Config> extends DefaultConfigurationFactoryFactory<T> {
		protected final String[] prefixes;
		private final String primaryPrefix;
		
		public ConfigFactoryFactory(String... prefixes) {
			this.prefixes = prefixes;
			this.primaryPrefix = Utilities.first(prefixes);
		}
		
		@Override
		public ConfigurationFactory<T> create(Class<T> klass, Validator validator, ObjectMapper mapper, String dwPrefix) {
			return new ConfigFactory<>(klass, validator, configureObjectMapper(mapper), StringUtils.defaultIfBlank(primaryPrefix, dwPrefix));
		}
	}
	
	public static class SSMConfigFactoryFactory<T extends Config & ParamStoreAwareConfig> extends ConfigFactoryFactory<T> {
		public SSMConfigFactoryFactory(String... prefixes) { super(prefixes); }
		
		@Override
		public ConfigurationFactory<T> create(Class<T> klass, Validator validator, ObjectMapper mapper, String dwPrefix) {
			var ret = super.create(klass, validator, mapper, dwPrefix);
			if (ret instanceof ConfigFactory<T> cf) {
				var env = ReplaceSecretsTree.envVarsSysProps(prefixes);
				var ssm = ReplaceSecretsTree.ssmParamsSecrets(prefixes);
				cf.setOverrides((config, $) -> {
					ssm.getSsm().enabled(config::isSsm);
					return ConfigOverrides.compose(env, ssm);
				});	
			}
			return ret;
		}
	}
}
