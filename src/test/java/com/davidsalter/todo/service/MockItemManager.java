/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.domain.ItemManager;

public class MockItemManager implements ItemManager {

	private List<Item> items = null;

	public MockItemManager() {
		items = new ArrayList<Item>();
		Item a = new Item();
		items.add(a);
		Item b = new Item();
		items.add(b);
	}

	public Item find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Item> getItems() {
		return items;
	}

	public void deleteItem(String itemId) {
		// TODO Auto-generated method stub

	}

	public void saveItem(Item item) {
		// TODO Auto-generated method stub

	}

	public void updateItem(Item item) {
		// TODO Auto-generated method stub

	}

	public int getOverdueCount() {
		return 1;
	}

	public int getItemCount() {
		return items.size();
	}

}
