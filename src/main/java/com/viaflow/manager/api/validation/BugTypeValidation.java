package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.bug.BugType;

@Component
public class BugTypeValidation implements BaseValidation<BugType> {

	@Override
	public boolean validateObject(BugType object, BindingResult result) {
		if (object.getBugTypeName() == null || object.getBugTypeName().isEmpty()) {
			result.addError(new ObjectError("BugType", "Field Bug Name should be informed"));
		}
		return !result.hasErrors();
	}

}
