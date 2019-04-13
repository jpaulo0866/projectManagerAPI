package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.customer.Customer;

@Component
public class CustomerValidation implements BaseValidation<Customer>{

	@Override
	public boolean validateObject(Customer object, BindingResult result) {
		if(object.getCustomerCnpj()==null || object.getCustomerCnpj().isEmpty()) {
			result.addError(new ObjectError("Customer", "Field Customer cnpj should be informed"));
		}
		if(object.getCustomerName()==null || object.getCustomerName().isEmpty()) {
			result.addError(new ObjectError("Customer", "Field Customer name should be informed"));
		}
		return !result.hasErrors();
	}

}
