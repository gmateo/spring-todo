/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.davidsalter.todo.domain.Item;
import com.davidsalter.todo.domain.ItemManager;
import com.davidsalter.todo.service.ItemValidator;

/**
 * Web controller responsible for updating items.
 * 
 * @author david@davidsalter.co.uk
 * 
 */
@Controller
@SessionAttributes("priorityList")
@RequestMapping("/updateItem.htm")
public class UpdateItemFormController {

	@Autowired
	private ItemValidator itemValidator;

	@Autowired
	private ItemManager itemManager;

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("item") Item item,
			BindingResult result) {

		System.out.println("Updating item");
		itemValidator.validate(item, result);
		if (result.hasErrors())
			return "editItem";

		itemManager.updateItem(item);
		return "redirect:items.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(ModelMap model,
			@RequestParam("itemId") String itemId) {
		// Perform and Model / Form initialization
		Item item = itemManager.find(Long.parseLong(itemId));
		model.addAttribute("item", item);

		Map<Integer, String> priority = new LinkedHashMap<Integer, String>();
		priority.put(1, "Low");
		priority.put(2, "Normal");
		priority.put(3, "High");

		model.addAttribute("priorityList", priority);
		return "editItem";
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public void setItemValidator(ItemValidator itemValidator) {
		this.itemValidator = itemValidator;
	}
}