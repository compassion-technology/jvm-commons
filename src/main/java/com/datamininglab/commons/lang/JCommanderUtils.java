/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.Arrays;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.datamininglab.commons.logging.LogContext;

/**
 * Convenience utilities when using {@link JCommander} to parse command-line arguments.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 15, 2016
 */
public final class JCommanderUtils {
	private JCommanderUtils() {
		// Prevent initialization
	}
	
	/**
	 * Parses command-line arguments using JCommander, printing out the usage if there are any problems.
	 * @param args the command line args
	 * @param objs one or more objects annotated with JCommander
	 * @return whether or not the arguments parsed successfully
	 * @see JCommander#addObject(Object)
	 */
	public static boolean parseArgs(String[] args, Object... objs) {
		JCommander jc = new JCommander();
		Arrays.asList(objs).forEach(o -> jc.addObject(o));
 		return parseArgs(args, jc);
	}
	
	/**
	 * Parses a series of separate "commands"- each one being an annotated with {@link JCommander}. The first arg is
	 * considered the command name and the subsequent args are specific to that command.
	 * @param args the command line args
	 * @param commands one or more commands annotated with JCommander
	 * @param <T> the common type among all commands
	 * @return the parsed command (one of the objects passed as the parameter) or <tt>null</tt> if there was a problem
	 * parsing the arguments
	 * @see JCommander#addCommand(Object)
	 */
	@SafeVarargs
	public static <T> T parseCommands(String[] args, T... commands) {
		JCommander jc = new JCommander();
		Arrays.asList(commands).forEach(c -> jc.addCommand(c));
		if (parseArgs(args, jc)) {
			String pc = jc.getParsedCommand();
			if (pc == null) {
				jc.usage();
				return null;
			}
			
			JCommander jcc = jc.getCommands().get(pc);
			return Utilities.cast(Utilities.first(jcc.getObjects()));
		}
		return null;
	}
	
	/**
	 * Parses command-line arguments using JCommander, printing out the usage if there are any problems.
	 * @param args the command line args
	 * @param jc the JCommander object, with any annotated objects and/or commands added
	 * @return whether or not the arguments parsed successfully
	 * @see JCommander#addCommand(Object)
	 * @see JCommander#addObject(Object)
	 */
	public static boolean parseArgs(String[] args, JCommander jc) {
		try {
 			jc.parse(args);
		} catch (ParameterException ex) {
			LogContext.warning("Argument error: " + ex.getMessage());
			jc.usage();
			return false;
		}
		return true;
	}
}
