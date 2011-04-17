/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.davidsalter.todo.domain.Item;

/**
 * JPA Implementation of the ItemDao interface responsible for database
 * persistence using JPA.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
@Component
public class JpaItemDao implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Item find(long itemId) {
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}

	public List<Item> getItemList() {
		Query query = entityManager
				.createQuery("from Item order by dueDate asc, priority desc, id asc");
		return query.getResultList();
	}

	public void deleteItem(String itemId) {
		Item toDelete = entityManager.find(Item.class, new Long(itemId));
		entityManager.remove(toDelete);
	}

	public void saveItem(Item item) {
		entityManager.persist(item);
	}

	public void updateItem(Item item) {
		entityManager.merge(item);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int getOverdueCount() {
		Query query = entityManager
				.createQuery("SELECT COUNT(i) FROM Item i where i.dueDate<NOW()");
		Number num = (Number) query.getSingleResult();
		return num.intValue();
	}

	public int getItemCount() {
		Query query = entityManager.createQuery("SELECT COUNT(i) FROM Item i");
		Number num = (Number) query.getSingleResult();
		return num.intValue();
	}
}
