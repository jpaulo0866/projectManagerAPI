package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.user.User;

@Component
public class UserValidation implements BaseValidation<User> {

	@Override
	public boolean validateObject(User object, BindingResult result) {
		return true;
	}
	
}
