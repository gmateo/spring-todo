/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.service.MockItemManager;

public class ItemListControllerTests {

	private ItemListController controller;

	@Before
	public void setup() {
		UserDetails user = new User("david", "secret", true, true, true, true,
				AuthorityUtils.createAuthorityList("MY_ROLE"));

		TestingAuthenticationToken authentication = new TestingAuthenticationToken(
				user, "secret");
		SecurityContextHolder.getContext().setAuthentication(authentication);

		controller = new ItemListController();
		controller.setItemManager(new MockItemManager());
	}

	@Test
	public void testHandleRequestView() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		assertEquals("items", modelAndView.getViewName());
	}

	@Test
	public void testModel() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		assertNotNull(modelMap);
	}

	@Test
	public void testModelNow() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String now = (String) modelMap.get("now");
		assertNotNull(now);
	}

	@Test
	public void testModelItems() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		List<Item> items = (List<Item>) modelMap.get("items");
		assertEquals(items.size(), 2);
	}

	@Test
	public void testModelOverdueCount() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		int overdueCount = (Integer) modelMap.get("overdueCount");
		assertEquals(overdueCount, 1);
	}

	@Test
	public void testModelItemCount() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		int overdueCount = (Integer) modelMap.get("itemCount");
		assertEquals(overdueCount, 2);
	}

	@Test
	public void testModelUsername() throws Exception {
		ModelAndView modelAndView = controller.handleRequest();
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String userName = (String) modelMap.get("username");
		assertEquals(userName, "david");
	}
}
