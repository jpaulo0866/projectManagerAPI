package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.documentation.TestTemplate;

@Component
public class TestTemplateValidation implements BaseValidation<TestTemplate>{

	@Override
	public boolean validateObject(TestTemplate object, BindingResult result) {
		return true;
	}

}
