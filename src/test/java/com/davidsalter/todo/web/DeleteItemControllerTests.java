/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.davidsalter.todo.service.MockItemManager;

/**
 * Tests for the DeleteItemController class
 * 
 * @author david@davidsalter.co.uk
 * @see DeleteItemController
 */
public class DeleteItemControllerTests {

	DeleteItemController controller;

	@Before
	public void setup() {
		controller = new DeleteItemController();
		MockItemManager itemManager = new MockItemManager();
		controller.setItemManager(itemManager);
	}

	@Test
	public void testHandleRequest() throws Exception {
		String result = controller.handleRequest("7");
		assertEquals("redirect:items.htm", result);
	}
}
