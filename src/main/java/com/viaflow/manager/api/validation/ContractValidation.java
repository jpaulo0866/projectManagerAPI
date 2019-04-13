package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.customer.Contract;

@Component
public class ContractValidation implements BaseValidation<Contract>{



	@Override
	public boolean validateObject(Contract object, BindingResult result) {
		if(object.getContractName()==null || object.getContractName().isEmpty()) {
			result.addError(new ObjectError("Contract", "Field Contract name should be informed"));
		}
		
		return !result.hasErrors();
	}

}
