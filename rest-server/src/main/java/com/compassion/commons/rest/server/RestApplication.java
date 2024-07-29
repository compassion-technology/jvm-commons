package com.compassion.commons.rest.server;

import org.apache.commons.lang3.ArrayUtils;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.configuration.UrlConfigurationSourceProvider;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;

/**
 * Convenience implementations of Dropwizard {@link Application} that assumes Swagger Javadocs are used and provides
 * easier APIs for registering resources. You should put a reference configuration file for your application in the
 * resources directory named {@code /reference.yml} in case callers don't manually specify the config file URL via
 * CLI args.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <C> the configuration type
 * @since Feb 18, 2017
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class RestApplication<C extends Configuration> extends Application<C> {
	private static final String SERVER = "server";
	private static final String DEF_DOCS_PATH = "/apidocs/ui", DEF_DOCS_URI = "/docs";
	public static final String DEF_CONFIG_URL = RestApplication.class.getResource("/reference.yml").toString();
	
	@Getter private String name;
	private String docsPath, docsUri;
	
	protected RestApplication(String name) {
		this(name, DEF_DOCS_PATH, DEF_DOCS_URI);
	}
	
	@Override
	protected void bootstrapLogging() {
		// This method (when not overridden) bombs start up because we are also using Log4j. Eventually, we would like
		// to remove all slf4j impls and leave the log4j impl of slf4j, but there still were import statments into
		// logback-classic as of Dropwizard 1.2.0. See:
		// http://www.dropwizard.io/1.2.0/docs/manual/core.html#logging
		// https://github.com/dropwizard/dropwizard/pull/2112
		// https://github.com/dropwizard/dropwizard/pull/1900
	}
	
	@Override
	public void initialize(Bootstrap<C> bootstrap) {
		bootstrap.addBundle(new AssetsBundle(docsPath, docsUri, "index.html"));
		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
			new UrlConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
	}
	
	@Override
	public void run(String... arguments) throws Exception {
		if (arguments.length == 0) {
			super.run(SERVER, DEF_CONFIG_URL);
		} else {
			super.run(ArrayUtils.insert(0, arguments, SERVER));	
		}
	}
	
	@Override
	public void run(C config, Environment environment) throws Exception {
		val j = environment.jersey();
		j.register(MultiPartFeature.class);
		j.register(CSVMessageWriter.class);
		registerResources(config, apis -> {
			for (val api : apis) { j.register(api); } 
		});
	}
	
	/**
	 * Invoke the callback with any resources that should be registered with the Jersey environment.
	 * @param c the application config
	 * @param r the callback to invoke to register each resource
	 */
	protected abstract void registerResources(C c, Registrar r);
	
	@FunctionalInterface
	protected interface Registrar {
		void register(Object... apis);
	}
}
