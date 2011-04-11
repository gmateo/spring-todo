package com.davidsalter.todo.repository;

import java.util.List;

import com.davidsalter.todo.domain.Item;

public interface ItemDao {

	public Item find(long id);
	public List<Item> getItemList();
	public void deleteItem(String itemId);
	public int getItemCount();
	public int getOverdueCount();
	public void saveItem(Item item);
	public void updateItem(Item item);

}
