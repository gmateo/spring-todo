/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(ModelMap model) {
		return "logout";
	}
}