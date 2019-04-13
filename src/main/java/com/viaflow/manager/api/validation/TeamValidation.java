package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.user.Team;

@Component
public class TeamValidation implements BaseValidation<Team> {

	@Override
	public boolean validateObject(Team object, BindingResult result) {
		if(object.getTeamName() == null) {
			result.addError(new ObjectError("Team", "Name is Null"));
		}
		if(object.getUsers() == null)
			result.addError(new ObjectError("Team", "User is Null"));

		return !result.hasErrors();
	}

}
