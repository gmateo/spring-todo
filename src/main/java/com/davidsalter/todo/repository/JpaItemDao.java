/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.davidsalter.todo.domain.Item;

@Component
public class JpaItemDao implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public Item find(long itemId) {
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}

	@Transactional(readOnly = true)
	public List<Item> getItemList() {
		Query query = entityManager
				.createQuery("from Item order by dueDate asc, priority desc");
		return query.getResultList();
	}

	@Transactional
	public void deleteItem(String itemId) {
		Item toDelete = entityManager.find(Item.class, new Long(itemId));
		entityManager.remove(toDelete);
	}

	@Transactional
	public void saveItem(Item item) {
		entityManager.persist(item);
	}

	@Transactional
	public void updateItem(Item item) {
		entityManager.merge(item);
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional(readOnly = true)
	public int getOverdueCount() {
		Query query = entityManager
				.createQuery("SELECT COUNT(i) FROM Item i where i.dueDate<NOW()");
		Number num = (Number) query.getSingleResult();
		return num.intValue();
	}

	@Transactional(readOnly = true)
	public int getItemCount() {
		Query query = entityManager.createQuery("SELECT COUNT(i) FROM Item i");
		Number num = (Number) query.getSingleResult();
		return num.intValue();
	}
}
