package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ChangeProjectTeam;

@Component
public class ChangeProjectTeamValidation implements BaseValidation<ChangeProjectTeam> {

	@Override
	public boolean validateObject(ChangeProjectTeam object, BindingResult result) {
		if (object.getTeamNew() == null) {
			result.addError(new ObjectError("ChangeProjectTeam", "Field New Team should be informed"));
		}
		if (object.getTeamOld() == null) {
			result.addError(new ObjectError("ChangeProjectTeam", "Field Old Team should be informed"));
		}
		if (object.getChangedUser() == null) {
			result.addError(new ObjectError("ChangeProjectTeam", "Field User should be informed"));
		}
		return !result.hasErrors();
	}

}
