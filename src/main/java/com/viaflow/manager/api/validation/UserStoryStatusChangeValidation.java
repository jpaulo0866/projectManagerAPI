package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.us.UserStoryStatusChange;

@Component
public class UserStoryStatusChangeValidation implements BaseValidation<UserStoryStatusChange> {

	@Override
	public boolean validateObject(UserStoryStatusChange object, BindingResult result) {
		if (object.getNewStatusUs() == null) {
			result.addError(new ObjectError("UserStoryStatusChange", "New Status User Status should be informed"));
		}
		if (object.getOldStatusUs() == null) {
			result.addError(new ObjectError("UserStoryStatusChange", "Old Status User Status should be informed"));
		}
		return !result.hasErrors();
	}

}
