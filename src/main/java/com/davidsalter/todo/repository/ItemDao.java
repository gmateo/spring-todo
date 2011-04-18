/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.repository;

import java.util.List;

import com.davidsalter.todo.domain.Item;

/**
 * DAO Interface for the Item entity class.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
public interface ItemDao {

	public Item find(long id);

	public List<Item> getItemList();

	public void deleteItem(long itemId);

	public int getItemCount();

	public int getOverdueCount();

	public void saveItem(Item item);

	public void updateItem(Item item);
}
