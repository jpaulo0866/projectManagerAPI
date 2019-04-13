package com.viaflow.manager.api.validation;

import org.springframework.validation.BindingResult;

import ch.qos.logback.core.status.Status;

public class ProjectStatusValidation implements BaseValidation<Status> {

	@Override
	public boolean validateObject(Status object, BindingResult result) {
		
		return false;
	}

}
