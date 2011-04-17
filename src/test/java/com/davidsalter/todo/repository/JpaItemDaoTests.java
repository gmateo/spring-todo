package com.davidsalter.todo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.davidsalter.todo.domain.Item;

/**
 * Tests for the JpaItemDao class
 * 
 * @author david@davidsalter.co.uk
 * @see JpaItemDao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class JpaItemDaoTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	private ItemDao itemDao;

	@Inject
	public void setItemDao(JpaItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Before
	public void setup() {
		createItems();
	}

	@Test
	public void testFind() throws Exception {
		List<Item> items = itemDao.getItemList();
		Item item = itemDao.find(items.get(0).getId());
		assertEquals(item.getDescription(), "My item");
	}

	@Test
	public void testGetItemList() throws Exception {
		List<Item> items = itemDao.getItemList();
		assertEquals(items.size(), 2);
		for (Item item : items) {
			System.out.println(item.toString());
		}
	}

	@Test
	public void testDeleteItem() throws Exception {
		addExtra();
		List<Item> items = itemDao.getItemList();
		assertEquals(items.size(), 3);
		Item item = itemDao.find(items.get(0).getId());
		itemDao.deleteItem("" + item.getId());
		items = itemDao.getItemList();
		assertEquals(items.size(), 2);
	}

	@Test
	public void testUpdateItem() throws Exception {
		List<Item> items = itemDao.getItemList();
		assertEquals(items.size(), 2);
		Long id = items.get(0).getId();
		Item item = itemDao.find(id);
		item.setDescription("updated");
		itemDao.updateItem(item);
		Item item2 = itemDao.find(id);
		assertEquals(item2.getDescription(), "updated");
	}

	@Test
	public void testGetItemCount() throws Exception {
		int items = itemDao.getItemCount();
		assertEquals(items, 2);
	}

	@Test
	public void testGetOverdueCount() throws Exception {
		int overdue = itemDao.getOverdueCount();
		assertEquals(overdue, 1);
	}

	@Transactional
	private void createItems() {
		Item item = new Item();
		item.setDescription("My item");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2000);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);

		item.setDueDate(cal.getTime());
		itemDao.saveItem(item);

		Item item2 = new Item();
		item2.setDescription("My item2");
		cal.add(Calendar.YEAR, 1000);
		item2.setDueDate(cal.getTime());
		itemDao.saveItem(item2);
	}

	@Transactional
	private void addExtra() {
		Item item3 = new Item();
		item3.setDescription("My item3");
		itemDao.saveItem(item3);
	}
}
