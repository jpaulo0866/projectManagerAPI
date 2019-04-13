package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.us.UserStory;

@Component
public class UserStoryValidation implements BaseValidation<UserStory> {

	@Override
	public boolean validateObject(UserStory object, BindingResult result) {
		if (object.getTitle() == null) {
			result.addError(new ObjectError("UserStory", "Field Title should be informed"));
		}
		if (object.getAppFiles() == null) {
			result.addError(new ObjectError("UserStory", "Field File should be informed"));
		}
		if (object.getUser() == null) {
			result.addError(new ObjectError("UserStory", "Field User should be informed"));
		}
		if (object.getResponsibleUser() == null) {
			result.addError(new ObjectError("UserStory", "Field ResponsibleUser should be informed"));
		}
		if (object.getResponsibleTeam() == null) {
			result.addError(new ObjectError("UserStory", "Field ResponsibleTeam should be informed"));
		}
		return !result.hasErrors();
	}

}
