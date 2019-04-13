package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ChangeProjectStatus;

@Component
public class ChangeProjectStatusValidation implements BaseValidation<ChangeProjectStatus> {

	@Override
	public boolean validateObject(ChangeProjectStatus object, BindingResult result) {
		if (object.getChangeProjectStatusOld() == null) {
			result.addError(new ObjectError("ChangeProjectStatus", "Field Project status old should be informed"));
		}
		if (object.getChangeProjectStatusNew() == null) {
			result.addError(new ObjectError("ChangeProjectStatus", "Field Project status new should be informed"));
		}
		if (object.getChangeProjectStatusUser() == null) {
			result.addError(new ObjectError("ChangeProjectStatus", "Field Project user should be informed"));
		}
		return !result.hasErrors();
	}

}
