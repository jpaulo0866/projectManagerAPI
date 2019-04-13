package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.viaflow.manager.api.entity.project.Status;

@Component
public class StatusValidation implements BaseValidation<Status> {

	@Override
	public boolean validateObject(Status object, BindingResult result) {
		if (object.getStatusName() == null || object.getStatusName().isEmpty()) {
			result.addError(new ObjectError("Status", "Field Project Status Name should be informed"));
		}
		return !result.hasErrors();
	}

}
