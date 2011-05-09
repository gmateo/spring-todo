/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.davidsalter.todo.domain.Item;

/**
 * JPA Implementation of the ItemDao interface responsible for database
 * persistence using JPA. Spring Cacheing is used to eliminate database reads.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
@Repository
public class JpaItemDao implements ItemDao {

	protected final Log logger = LogFactory.getLog(getClass());

	@PersistenceContext
	private EntityManager entityManager;

	@Cacheable(value = "items", key = "#itemId")
	public Item find(long itemId) {
		Item item = entityManager.find(Item.class, itemId);
		return item;
	}

	public List<Item> getItemList() {
		Query query = entityManager
				.createQuery("from Item order by dueDate asc, priority desc, id asc");
		return query.getResultList();
	}

	@CacheEvict(value = "items")
	public void deleteItem(long itemId) {
		Item toDelete = entityManager.find(Item.class, new Long(itemId));
		entityManager.remove(toDelete);
	}

	public void saveItem(Item item) {
		entityManager.persist(item);
	}

	@CacheEvict(value = "items", key = "#item.id")
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
