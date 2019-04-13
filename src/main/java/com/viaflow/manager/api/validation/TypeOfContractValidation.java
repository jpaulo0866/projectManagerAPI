package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.customer.TypeOfContract;

@Component
public class TypeOfContractValidation implements BaseValidation<TypeOfContract> {

	@Override
	public boolean validateObject(TypeOfContract object, BindingResult result) {
		if (object.getTypeOfContractName() == null
				|| object.getTypeOfContractName().isEmpty()) {
			result.addError(new ObjectError("Type of contract", "Field Type of contract Name should be informed"));
		}
		return !result.hasErrors();
	}

}

