package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


import com.viaflow.manager.api.entity.project.StatusPermissionByProfile;

@Component
public class StatusPermissionByProfileValidation implements BaseValidation<StatusPermissionByProfile> {

	@Override
	public boolean validateObject(StatusPermissionByProfile object, BindingResult result) {
		
		return true;
	}

}
