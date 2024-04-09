package com.compassion.commons.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.jooq.lambda.Seq;

import com.compassion.commons.LambdaUtils;

import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParseResult;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Spec.Target;

// Adapted from https://github.com/remkop/picocli/blob/main/picocli-examples/src/main/java/picocli/examples/logging_mixin_advanced/LoggingMixin.java
public class LoggingMixin {
	@Spec(Target.MIXEE)
    private CommandSpec mixee; // spec of the command where the @Mixin is used

    private boolean[] verbosity = new boolean[] { true };

    private static LoggingMixin getTopLevelCommandLoggingMixin(CommandSpec commandSpec) {
    	if (commandSpec.root().userObject() instanceof HasLoggingMixin withMixin) {
    		return withMixin.getLoggingMixin();
    	}
    	return null;
    }

    @Option(names = {"-v", "--verbose"}, description = {
                    "Specify multiple -v options to increase verbosity.",
                    "For example, `-v -v -v` or `-vvv`"})
    public void setVerbose(boolean... verbosity) {
    	LambdaUtils.accept(getTopLevelCommandLoggingMixin(mixee), $ -> $.verbosity = verbosity);
    }
    
    public static int executionStrategy(ParseResult parseResult) {
        LambdaUtils.accept(getTopLevelCommandLoggingMixin(parseResult.commandSpec()), LoggingMixin::configureLoggers);
        return new CommandLine.RunLast().execute(parseResult);
    }

    private void configureLoggers() {
        var logLvl = calcLogLevel(verbosity);
        var logCtx = LoggerContext.getContext(false);
        var root   = logCtx.getConfiguration().getRootLogger();
        
        Seq.seq(root.getAppenders().values()).ofType(ConsoleAppender.class).forEach(appender -> {
        	root.removeAppender(appender.getName());
            root.addAppender(appender, logLvl, null);
        });
        if (root.getLevel().isMoreSpecificThan(logLvl)) {
            root.setLevel(logLvl);
        }
        logCtx.updateLoggers();
    }

    private static Level calcLogLevel(boolean... verbosity) {
        switch (verbosity.length) {
            case 0:  return Level.WARN;
            case 1:  return Level.INFO;
            case 2:  return Level.DEBUG;
            case 3:  return Level.TRACE;
            default: return Level.ALL;   
        }
    }
}