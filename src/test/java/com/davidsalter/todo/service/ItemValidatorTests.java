/*
 * Simple Spring based To Do list.
 */
package com.davidsalter.todo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.davidsalter.todo.domain.Item;

public class ItemValidatorTests {

	@Test
	public void testSupports() {
		ItemValidator validator = new ItemValidator();
		assertTrue(validator.supports(Item.class));
		assertFalse(validator.supports(String.class));
	}

	@Test
	public void testValidateNoDescription() throws Exception {
		ItemValidator validator = new ItemValidator();
		Item item = new Item();
		Errors errors = new BindException(item, "item");
		validator.validate(item, errors);
		assertTrue(errors.hasErrors());
		List<FieldError> ferrors = errors.getFieldErrors("description");
		for (FieldError fe : ferrors) {
			assertEquals("error.no-description", fe.getCode());
		}
	}

	@Test
	public void testValidateNoItem() throws Exception {
		ItemValidator validator = new ItemValidator();
		Item item = new Item();
		Errors errors = new BindException(item, "item");
		validator.validate(null, errors);
		assertTrue(errors.hasErrors());
		List<FieldError> ferrors = errors.getFieldErrors("description");
		for (FieldError fe : ferrors) {
			assertEquals("error.not-specified", fe.getCode());
		}

	}
}
