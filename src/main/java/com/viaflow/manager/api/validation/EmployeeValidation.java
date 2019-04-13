package com.viaflow.manager.api.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.employee.Employee;
@Component
public class EmployeeValidation implements BaseValidation<Employee> {

	
	
	
	// Valid Employee is null
	
	@Override
	public boolean validateObject(Employee object, BindingResult result) {
		if (object.getPerson() == null ) {
			result.addError(new ObjectError("Person", "Field Employee Person Ref is null"));
		}
		
		if (object.getSalary() ==  0) {
			result.addError(new ObjectError("Person", "Field Employee salary should be informed"));
		}
		
		if (object.getHireDate() == null) {
			result.addError(new ObjectError("Person", "Field Employee Hire Date should be informed"));
		}
		if(object.getRole() == null) {
			result.addError(new ObjectError("Person", "Role is null"));
		}
		
		return !result.hasErrors();
	}
		
}
