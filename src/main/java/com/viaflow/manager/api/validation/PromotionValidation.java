package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.entity.employee.Promotion;
@Component
public class PromotionValidation implements BaseValidation<Promotion> {

	@Override
	public boolean validateObject(Promotion object, BindingResult result) {
		return true;
	}

}
