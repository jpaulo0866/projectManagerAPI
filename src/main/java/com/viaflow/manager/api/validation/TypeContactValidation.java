package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.person.TypeContact;

@Component
public class TypeContactValidation implements BaseValidation<TypeContact>{

	@Override
	public boolean validateObject(TypeContact object, BindingResult result) {
		if (object.getTypeContactName() == null || object.getTypeContactName().isEmpty()) {
			result.addError(new ObjectError("TypeContact", "Field Type of contact name should be informed"));
		}
		
 		return !result.hasErrors();
	}
}
