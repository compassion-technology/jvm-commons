/*
 * Copyright (c) 2012 Elder Research, Inc.
 * All rights reserved. 
 */
package com.datamininglab.commons.lang;

import java.util.concurrent.TimeUnit;

import com.datamininglab.commons.logging.LogContext;

/**
 * A listener that receives updates when a status monitor changes state.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 29, 2012
 */
public interface StatusListener {
	/**
	 * Invoked when either the state, status, size or progess of the task has changed.
	 * @param sm the current status of the task
	 */
	void statusChanged(StatusMonitor sm);
	
	/**
	 * Get the minimum time between notifications for this listener.
	 * @return the notification interval (in nanoseconds)
	 */
	long getNotifyIntervalNS();
	
	public static class DefaultStatusListener implements StatusListener {
		private static final long NOTIFY_S = 5L;
		private static final double PCT_COEFF = 100.0;
		
		@Override
		public long getNotifyIntervalNS() {
			return TimeUnit.NANOSECONDS.convert(NOTIFY_S, TimeUnit.SECONDS);
		}
		
		@Override
		public void statusChanged(StatusMonitor sm) {
			if (sm.getSize() < 0L) {
				print(sm, sm.getStatus());
			} else {
				double pct = PCT_COEFF * sm.getProgress() / sm.getSize();
				print(sm, String.format("%6s/%6s (%6.2f%%) %s",
						Utilities.compactLargeNumber(sm.getProgress()),
						Utilities.compactLargeNumber(sm.getSize()), pct, sm.getStatus()));
			}
		}
		
		private static void print(StatusMonitor sm, String str) {
			LogContext.info("[%-9s] %s", sm.getState(), str);
		}
	}
}