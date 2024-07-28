/* ©2020-2021 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.rest.client;

import java.util.logging.Level;

import org.glassfish.jersey.logging.LoggingFeature.Verbosity;

import com.compassion.commons.config.YAMLConfig;
import com.elderresearch.commons.rest.client.WebParam.WebHeader;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class RestClientConfig extends YAMLConfig {
	private String url, logLevel;
	private Verbosity logVerbosity = Verbosity.PAYLOAD_TEXT;
	
	/**
	 * Parse the log level into a JUL level enum.
	 * @param defVal the default value to use if the log level was not specified
	 * or did not resolve to a known JUL log level.
	 * @return the log level as a {@link Level}
	 * @see Level#parse(String)
	 */
	public Level parseLogLevel(Level defVal) {
		try {
			return Level.parse(getLogLevel());
		} catch (IllegalArgumentException | NullPointerException ex) {
			return defVal;
		}		
	}
	
	/**
	 * Sets the log level based on if requests (and responses) to/from the API should be logged.
	 * This is an optional convenience method. 
	 * @param logRequests whether or not to log the requests
	 * @return this for method chaining
	 * @see #setLogLevel(String)
	 */
	public RestClientConfig setLogRequests(boolean logRequests) {
		// By promoting log level to INFO, it will show up under default log configs
		// that show INFO messages and higher
		return setLogLevel(logRequests? Level.INFO.getName() : Level.FINE.getName());
	}
	
	/**
	 * Represent this configuration as an authentication parameter. This is usually
	 * a {@link WebHeader} with a key or token. The default implementation is to 
	 * return {@code null} but subclasses can override this method for their API.
	 * @return this configuration as an authentication parameter
	 */
	public WebParam asAuthParam() {
		return null;
	}
}
