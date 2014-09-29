/*
 * Copyright (c) 2013 Elder Research, Inc.
 * All rights reserved.
 */
package com.datamininglab.commons.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.datamininglab.commons.logging.LogContext;

/**
 * This class calls {@link Runtime#exec(String)} but pipes output and error
 * streams to the logger and waits for the process to finish.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Mar 3, 2013
 */
public final class RuntimeExec extends Thread {
	private boolean isError;
	private InputStream stream;
	
	private RuntimeExec(InputStream stream, boolean isError) {
		this.stream = stream;
		this.isError = isError;
	}

	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				if (isError) {
					LogContext.warning(line);
				} else {
					LogContext.info(line);
				}
			}
		} catch (IOException e) {
			LogContext.severe(e, "Error reading process stream");
		}
	}

	public static int exec(String cmd) {
		Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			LogContext.warning(e, "Error executing command");
			return -1;
		}
		
		new RuntimeExec(p.getErrorStream(), true).start();
		new RuntimeExec(p.getInputStream(), false).start();
		
		try {
			return p.waitFor();
		} catch (InterruptedException e) {
			LogContext.warning(e, "Interrupted waiting for process");
			return -1;
		}
	}
}
