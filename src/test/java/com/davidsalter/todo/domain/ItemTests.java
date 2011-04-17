/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 * Tests for the Item class
 * 
 * @author david@davidsalter.co.uk
 * @see Item
 */
public class ItemTests {

	@Test
	public void testItem() throws Exception {
		Long id = 7L;
		String description = "My Test Description";
		Date dueDate = new Date();
		int priority = 2;
		Item item = new Item();
		item.setDescription(description);
		item.setDueDate(dueDate);
		item.setId(id);
		item.setPriority(priority);

		assertEquals(item.getDescription(), description);
		assertEquals(item.getDueDate(), dueDate);
		assertEquals(item.getId(), id);
		assertEquals(item.getPriority(), priority);
	}

	@Test
	public void testItemPriorityString() throws Exception {
		Item item = new Item();
		item.setPriority(1);
		assertEquals(item.getPriorityString(), "Low");
		item.setPriority(2);
		assertEquals(item.getPriorityString(), "Normal");
		item.setPriority(3);
		assertEquals(item.getPriorityString(), "High");
	}
}
