/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.domain;

import java.io.Serializable;
import java.util.List;

public interface ItemManager extends Serializable {

	public Item find(long id);

	public List<Item> getItems();

	public void deleteItem(long itemId);

	public void saveItem(Item item);

	public void updateItem(Item item);

	public int getOverdueCount();

	public int getItemCount();

}