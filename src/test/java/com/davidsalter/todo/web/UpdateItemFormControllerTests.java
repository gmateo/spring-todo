/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.service.ItemValidator;
import com.davidsalter.todo.service.MockItemManager;

/**
 * Tests for the UpdateItemFormController class
 * 
 * @author david@davidsalter.co.uk
 * @see UpdateItemFormController
 */
public class UpdateItemFormControllerTests {

	private UpdateItemFormController controller;

	@Before
	public void setup() {
		controller = new UpdateItemFormController();
		controller.setItemManager(new MockItemManager());
		controller.setItemValidator(new ItemValidator());
	}

	@Test
	public void testOnSubmitNoErrors() throws Exception {
		Item item = new Item();
		item.setDescription("A description");
		BindingResult br = new BindException(item, "item");
		String result = controller.onSubmit(item, br);
		assertEquals("redirect:items.htm", result);
	}

	@Test
	public void testOnSubmitErrors() throws Exception {
		Item item = new Item();
		BindingResult br = new BindException(item, "item");
		String result = controller.onSubmit(item, br);
		assertEquals("editItem", result);
	}

	@Test
	public void testInitializeFormView() throws Exception {
		ModelMap map = new ModelMap();
		String result = controller.initializeForm(map, 1L);
		assertEquals("editItem", result);
	}

	@Test
	public void testInitializeFormMap() throws Exception {
		ModelMap map = new ModelMap();
		String result = controller.initializeForm(map, 1L);
		assertEquals(2, map.size());

		Map<Integer, String> priorityList = (Map<Integer, String>) map
				.get("priorityList");
		assertEquals(priorityList.size(), 3);
	}
}
