package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ChangeProjectStage;

@Component
public class ChangeProjectStageValidation implements BaseValidation<ChangeProjectStage> {

	@Override
	public boolean validateObject(ChangeProjectStage object, BindingResult result) {
		if (object.getStageNew() == null) {
			result.addError(new ObjectError("ChangeProjectStage", "Field New Stage should be informed"));
		}
		if (object.getStageOld() == null) {
			result.addError(new ObjectError("ChangeProjectStage", "Field Old Stage should be informed"));
		}
		if (object.getChangedUser() == null) {
			result.addError(new ObjectError("ChangeProjectStage", "Field User should be informed"));
		}
		return !result.hasErrors();
	}

}
