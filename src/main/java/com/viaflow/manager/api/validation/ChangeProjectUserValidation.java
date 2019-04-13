package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ChangeProjectUser;

@Component
public class ChangeProjectUserValidation implements BaseValidation<ChangeProjectUser> {

	@Override
	public boolean validateObject(ChangeProjectUser object, BindingResult result) {
		if (object.getUserNew() == null) {
			result.addError(new ObjectError("ChangeProjectUser", "Field New User should be informed"));
		}
		if (object.getUserOld() == null) {
			result.addError(new ObjectError("ChangeProjectUser", "Field Old User should be informed"));
		}
		if (object.getChangedUser() == null) {
			result.addError(new ObjectError("ChangeProjectUser", "Field User should be informed"));
		}
		return !result.hasErrors();
	}

}
