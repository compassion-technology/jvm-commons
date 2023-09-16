/* ©2019-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.compassion.commons.CalendarUtils;

public class CalendarUtilsTest {
	@Test
	public void testAccess() {
		assertEquals(5, CalendarUtils.valueOf("DATE"));
	}
}
