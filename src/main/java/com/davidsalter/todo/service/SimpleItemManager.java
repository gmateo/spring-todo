package com.davidsalter.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.domain.ItemManager;
import com.davidsalter.todo.repository.ItemDao;

@Component
public class SimpleItemManager implements ItemManager {

	@Autowired
    private ItemDao itemDao;
    
	public Item find(long itemId) {
		return itemDao.find(itemId);
	}
	
    public List<Item> getItems() {
        return itemDao.getItemList();
    }

	public void saveItem(Item item) {
		itemDao.saveItem(item);
	}

	public void deleteItem(String itemId) {
		itemDao.deleteItem(itemId);
	}
	
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	public int getOverdueCount() {
		return itemDao.getOverdueCount();
	}
	
	public int getItemCount() {
		return itemDao.getItemCount();
	}
}