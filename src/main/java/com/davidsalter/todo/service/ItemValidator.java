package com.davidsalter.todo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.davidsalter.todo.domain.Item;

@Component
public class ItemValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
        return Item.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        Item addItem = (Item) obj;
        if (addItem == null) {
            errors.rejectValue("description", "error.not-specified", null, "Value required.");
        }
        else {
            logger.info("Validating with " + addItem + ": " + addItem.getDescription());
            if (addItem.getDescription().length()==0) {
                errors.rejectValue("description", "error.no-description",
                    null);
            }
        }
    }
}
