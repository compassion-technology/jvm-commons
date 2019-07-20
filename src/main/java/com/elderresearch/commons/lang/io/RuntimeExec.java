/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import com.elderresearch.commons.lang.LambdaUtils.Interruptable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.val;
import lombok.extern.log4j.Log4j2;

/**
 * This class calls {@link Runtime#exec(String)} but pipes output and error
 * streams to the logger and waits for the process to finish.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 3, 2013
 */
@Log4j2
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class RuntimeExec extends Thread {
	private InputStream stream;
	private Consumer<String> lineHandler;

	@Override
	public void run() {
		try {
			val isr = new InputStreamReader(stream);
			val br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) { lineHandler.accept(line); }
		} catch (IOException e) {
			log.error("Error reading process stream", e);
		}
	}

	public static int exec(String cmd) {
		return exec(cmd, log::info, log::warn);
	}
	
	public static int exec(String cmd, Consumer<String> outHandler, Consumer<String> errorHandler) {
		Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			log.warn("Error executing command", e);
			return -1;
		}
		
		new RuntimeExec(p.getInputStream(), outHandler).start();
		new RuntimeExec(p.getErrorStream(), errorHandler).start();
		
		return Interruptable.get(p::waitFor, "waiting for process", -1);
	}
}
