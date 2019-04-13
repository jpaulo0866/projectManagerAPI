package com.viaflow.manager.api.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.us.UserStoryChangeResponsibleTeam;

public class UserStoryChangeResponsibleTeamValidation implements BaseValidation<UserStoryChangeResponsibleTeam> {

	@Override
	public boolean validateObject(UserStoryChangeResponsibleTeam object, BindingResult result) {

		if (object.getChangeTeam() == null) {
			result.addError(new ObjectError("UserStoryChangeResponsibleTeam", " Change Team should be informed"));
		}
		if (object.getNewTeam() == null) {
			result.addError(new ObjectError("UserStoryChangeResponsibleTeam", "New Team should be informed"));
		}
		if (object.getPreviousTeam() == null) {
			result.addError(new ObjectError("UserStoryChangeResponsibleTeam", " Previous Team should be informed"));
		}
		return !result.hasErrors();
	}

}
