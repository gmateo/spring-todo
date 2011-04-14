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

public class AddItemFormControllerTests {

	private AddItemFormController controller;

	@Before
	public void setup() {
		controller = new AddItemFormController();
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
		assertEquals("addItem", result);
	}

	@Test
	public void testInitializeFormView() throws Exception {
		ModelMap map = new ModelMap();
		String result = controller.initializeForm(map);
		assertEquals("addItem", result);
	}

	@Test
	public void testInitializeFormMap() throws Exception {
		ModelMap map = new ModelMap();
		String result = controller.initializeForm(map);
		assertEquals(2, map.size());

		Item item = (Item) map.get("item");
		assertEquals(item.getDescription(), "");
		assertEquals(item.getPriority(), 2);

		Map<Integer, String> priorityList = (Map<Integer, String>) map
				.get("priorityList");
		assertEquals(priorityList.size(), 3);
	}

}
