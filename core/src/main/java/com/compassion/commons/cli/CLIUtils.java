package com.compassion.commons.cli;

import org.fusesource.jansi.AnsiConsole;

import com.compassion.commons.log.HasLoggingMixin;
import com.compassion.commons.log.LoggingMixin;

import lombok.extern.log4j.Log4j2;
import picocli.CommandLine;
import picocli.CommandLine.ExitCode;
import picocli.CommandLine.IExecutionExceptionHandler;

@Log4j2
public class CLIUtils {
	/**
	 * Sets common system properties needed in CLIs, like expanding the width of the CLI
	 * help to 100 characters (which fits on most modern laptops/monitors) and disabling
	 * JOOQ's tips.
	 */
	public static void initSysProps() {
		System.setProperty("org.jooq.no-logo", "true");
		System.setProperty("org.jooq.no-tips", "true");
		System.setProperty("picocli.usage.width", "100");
	}
	
	
	/**
	 * Initializes the CLI and executes it, exiting the JVM with the returned exit code. Includes:
	 * <ul><li>Installing and uninstalling an {@link AnsiConsole}</li>
	 * <li>Setting common system properties via {@link #initSysProps()}<li>
	 * <li>Everything in {@link #exec(Object, String...)}</ul>
	 * @param cli the CLI implementation
	 * @param args the command line args
	 * @see ExitCode
	 * @see System#exit(int)
	 */
	public static void execRoot(Object cli, String... args) {
		initSysProps();
		AnsiConsole.systemInstall();
		var ret = exec(cli, args);
		AnsiConsole.systemUninstall();
		System.exit(ret);
	}
	
	/**
	 * Initializes the CLI and executes it, returning the exit code. Includes:
	 * <li>Allowing case-insensitive enum values</li>
	 * <li>If no default exception handler has been registered, log the exception with the command
	 * context. Otherwise, delegate to the default exception handler.</li>
	 * <li>If the CLI uses the {@link LoggingMixin} to dynamically adjust the log level,
	 * register the logging mixin execution strategy</li></ul>
	 * @param cli the CLI implementation
	 * @param args the command line args
	 * @return the exit code
	 * @see ExitCode
	 */
	public static int exec(Object cli, String... args) {
		// Reroute any exceptions to the default handler, which delegates to COFTool's handling.
		// This unifies exception handling across CLIs and other contexts, like Lambda
		IExecutionExceptionHandler exHandler = (e, cmd, res) -> {
			var defHandler = Thread.getDefaultUncaughtExceptionHandler();
			if (defHandler == null) {
				log.error("Error running {} with arguments {}", cli, args, e);
			} else {
				defHandler.uncaughtException(Thread.currentThread(), e);
			}
			return ExitCode.SOFTWARE;
		};
		
		var cmd = new CommandLine(cli)
			.setExecutionExceptionHandler(exHandler)
			.setCaseInsensitiveEnumValuesAllowed(true);
		if (cli instanceof HasLoggingMixin) {
			cmd.setExecutionStrategy(LoggingMixin::executionStrategy);
		}
		return cmd.execute(args);
	}
}
