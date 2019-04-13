package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.person.Contact;

@Component
public class ContactValidation implements BaseValidation<Contact>{

	@Override
	public boolean validateObject(Contact object, BindingResult result) {
		if (object.getValue() == null || object.getValue().isEmpty()) {
			result.addError(new ObjectError("Contact", "Field Value should be informed"));
		}
		
		return !result.hasErrors();
	}
}
