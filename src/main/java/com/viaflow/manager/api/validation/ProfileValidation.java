package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


import com.viaflow.manager.api.entity.user.Profile;


@Component
public class ProfileValidation implements BaseValidation<Profile> {

	@Override
	public boolean validateObject(Profile object, BindingResult result) {
		if (object.getProfileName() == null
				|| object.getProfileName().isEmpty()) {
			result.addError(new ObjectError("Profile", "Field Profile Name should be informed"));
		}
		return !result.hasErrors();
	}

}
