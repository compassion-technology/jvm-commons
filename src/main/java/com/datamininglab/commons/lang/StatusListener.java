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
		private static final double PCT_COEFF = 100.0;
		private static final long NOTIFY_NS = TimeUnit.NANOSECONDS.convert(10L, TimeUnit.SECONDS); 
		
		@Override
		public long getNotifyIntervalNS() { return NOTIFY_NS; }
		
		@Override
		public void statusChanged(StatusMonitor sm) {
			if (sm.getSize() < 0L) {
				print(String.format("[%-9s] %s", sm.getState()));
			} else {
				double pct = PCT_COEFF * sm.getProgress() / sm.getSize();
				print(String.format("[%-9s] %6s/%6s (%6.2f%%) %s", sm.getState(),
						Utilities.compactLargeNumber(sm.getProgress()),
						Utilities.compactLargeNumber(sm.getSize()), pct, sm.getStatus()));
			}
		}
		
		protected void print(String str) {
			LogContext.info(str);
		}
	}
}