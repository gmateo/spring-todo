/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LogoutControllerTests {

	@Test
	public void testInitializeForm() throws Exception {
		LogoutController controller = new LogoutController();
		assertEquals(controller.initializeForm(null), "logout");
	}
}
