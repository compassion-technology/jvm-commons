/* ©2012-2020 Elder Research, Inc. All rights reserved. */
package com.elderresearch.commons.lang;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import lombok.extern.log4j.Log4j2;

/**
 * A listener that receives updates when a status monitor changes state.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 29, 2012
 */
@FunctionalInterface
public interface StatusListener {
	/** Default listener notify interval (see {@link #getNotifyIntervalNS()}).*/
	long DEFAULT_NOTIFY_NS = TimeUnit.NANOSECONDS.convert(10L, TimeUnit.SECONDS);
	
	/**
	 * Invoked when either the state, status, size or progess of the task has changed.
	 * @param sm the current status of the task
	 */
	void statusChanged(StatusMonitor sm);
	
	/**
	 * Get the minimum time between notifications for this listener.
	 * @return the notification interval (in nanoseconds)
	 */
	default long getNotifyIntervalNS() { return DEFAULT_NOTIFY_NS; }
	
	@Log4j2
	class DefaultStatusListener implements StatusListener {
		private static final double PCT_COEFF = 100.0;
		
		private Consumer<String> printer;
		
		public DefaultStatusListener(Consumer<String> printer) {
			this.printer = printer;
		}
		
		@Override
		public void statusChanged(StatusMonitor sm) {
			if (sm.getSize() < 1L) {
				if (sm.getProgress() > 0L) {
					printer.accept(String.format("[%-9s] %6s %s",
						sm.getState(),
						Utilities.compactLargeNumber(sm.getProgress()),
						sm.getStatus()));
				} else {
					printer.accept(String.format("[%-9s] %s",
						sm.getState(),
						sm.getStatus()));	
				}
			} else {
				printer.accept(String.format("[%-9s] %6s/%6s (%6.2f%%) %s",
					sm.getState(),
					Utilities.compactLargeNumber(sm.getProgress()),
					Utilities.compactLargeNumber(sm.getSize()),
					PCT_COEFF * sm.getProgress() / sm.getSize(),
					sm.getStatus()));
			}
		}
	}
	
	public static final DefaultStatusListener LOG = new DefaultStatusListener(DefaultStatusListener.log::info);
	public static final DefaultStatusListener CONSOLE = new DefaultStatusListener(System.out::println);
}
