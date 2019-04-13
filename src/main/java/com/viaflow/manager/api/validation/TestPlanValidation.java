package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.documentation.TestPlan;

@Component
public class TestPlanValidation implements BaseValidation<TestPlan> {

	@Override
	public boolean validateObject(TestPlan object, BindingResult result) {
		return true;
	}

}
