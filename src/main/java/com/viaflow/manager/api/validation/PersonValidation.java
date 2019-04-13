package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.person.Person;

@Component
public class PersonValidation implements BaseValidation<Person>{

	@Override
	public boolean validateObject(Person object, BindingResult result) {
		if (object.getFirstName() == null || object.getFirstName().isEmpty()) {
			result.addError(new ObjectError("Role", "Field First Name should be informed"));
		}
		
		if (object.getLastName() == null || object.getLastName().isEmpty()) {
			result.addError(new ObjectError("Role", "Field Last Name should be informed"));
		}
		
 		return !result.hasErrors();
	}
	
}
