package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.documentation.TestExecution;

@Component
public class TestExecutionValidation implements BaseValidation<TestExecution>{

	@Override
	public boolean validateObject(TestExecution object, BindingResult result) {
		return true;
	}

}
