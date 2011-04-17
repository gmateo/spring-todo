/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.domain.ItemManager;
import com.davidsalter.todo.repository.ItemDao;

/**
 * Item manager service layer.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
@Component
public class SimpleItemManager implements ItemManager {

	@Autowired
	private ItemDao itemDao;

	@Transactional(readOnly = true)
	public Item find(long itemId) {
		return itemDao.find(itemId);
	}

	@Transactional
	public List<Item> getItems() {
		return itemDao.getItemList();
	}

	@Transactional
	public void saveItem(Item item) {
		itemDao.saveItem(item);
	}

	@Transactional
	public void deleteItem(String itemId) {
		itemDao.deleteItem(itemId);
	}

	@Transactional
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	@Transactional(readOnly = true)
	public int getOverdueCount() {
		return itemDao.getOverdueCount();
	}

	@Transactional(readOnly = true)
	public int getItemCount() {
		return itemDao.getItemCount();
	}
}