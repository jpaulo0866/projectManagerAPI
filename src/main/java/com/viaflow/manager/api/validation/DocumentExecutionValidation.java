package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.documentation.DocumentExecution;

@Component
public class DocumentExecutionValidation implements BaseValidation<DocumentExecution>{

	@Override
	public boolean validateObject(DocumentExecution object, BindingResult result) {
		return true;
	}

}
