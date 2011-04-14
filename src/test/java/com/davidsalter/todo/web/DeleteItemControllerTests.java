/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import org.junit.Before;

import com.davidsalter.todo.service.MockItemManager;

public class DeleteItemControllerTests {

	DeleteItemController controller;

	@Before
	public void setup() {
		controller = new DeleteItemController();
		MockItemManager itemManager = new MockItemManager();
		controller.setItemManager(itemManager);
	}
}
