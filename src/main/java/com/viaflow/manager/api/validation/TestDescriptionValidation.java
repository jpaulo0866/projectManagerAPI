package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.documentation.TestDescription;

@Component
public class TestDescriptionValidation implements BaseValidation<TestDescription>  {

	@Override
	public boolean validateObject(TestDescription object, BindingResult result) {
		return true;
	}

}
