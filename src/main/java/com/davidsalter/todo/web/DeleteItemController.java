package com.davidsalter.todo.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.davidsalter.todo.domain.ItemManager;

@Controller
@RequestMapping("/deleteItem.htm")
public class DeleteItemController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ItemManager itemManager;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("itemId") String itemId) {
		String now = (new java.util.Date()).toString();
		logger.info("returning hello view with " + now);
		
		logger.info("Deleting item:"+itemId);
		itemManager.deleteItem(itemId);

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("items", this.itemManager.getItems());
		myModel.put("overdueCount", itemManager.getOverdueCount());
		myModel.put("itemCount", itemManager.getItemCount());
		myModel.put("username", user.getUsername());

		return new ModelAndView("items", "model", myModel);
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}