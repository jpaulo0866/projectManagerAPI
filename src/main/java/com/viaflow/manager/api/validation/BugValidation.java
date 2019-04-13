package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.bug.Bug;

@Component
public class BugValidation implements BaseValidation<Bug> {

	@Override
	public boolean validateObject(Bug object, BindingResult result) {
		if (object.getBugType() == null) {
			result.addError(new ObjectError("Bug", "Field BugType should be informed"));
		}
		if (object.getDescription() == null) {
			result.addError(new ObjectError("Bug", "Field Description should be informed"));
		}
		if (object.getUser() == null) {
			result.addError(new ObjectError("Bug", "Field User should be informed"));
		}
		if (object.getUserResponse() == null) {
			result.addError(new ObjectError("Bug", "Field UserResponse should be informed"));
		}
		if (object.getUserStory() == null) {
			result.addError(new ObjectError("Bug", "Field UserStory should be informed"));
		}
		return !result.hasErrors();
	}

}
