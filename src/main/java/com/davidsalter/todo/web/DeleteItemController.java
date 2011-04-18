/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.davidsalter.todo.domain.ItemManager;

/**
 * Web controller responsible for deleting items.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
@Controller
@RequestMapping("/deleteItem.htm")
public class DeleteItemController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ItemManager itemManager;

	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest(@RequestParam("itemId") Long itemId) {
		logger.info("Deleting item:" + itemId);
		itemManager.deleteItem(itemId);

		return "redirect:items.htm";
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
}