package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.us.UserStoryChangeUserResponsible;

@Component
public class UserStoryChangeUserResponsibleValidation implements BaseValidation<UserStoryChangeUserResponsible> {

	@Override
	public boolean validateObject(UserStoryChangeUserResponsible object, BindingResult result) {
		if (object.getChangeUserResponsible() == null) {
			result.addError(new ObjectError("UserStoryChangeUserResponsible", "Change User should be informed"));
		}
		if (object.getNewChangeUserResponsible() == null) {
			result.addError(
					new ObjectError("UserStoryChangeUserResponsible", "New Change User Responsible should be informed"));
		}

		return false;
	}

}
