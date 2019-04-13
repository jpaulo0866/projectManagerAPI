package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.employee.Role;

@Component
public class RoleValidation implements BaseValidation<Role> {

	@Override
	public boolean validateObject(Role object, BindingResult result) {
		if (object.getRoleName() == null
				|| object.getRoleName().isEmpty()) {
			result.addError(new ObjectError("Role", "Field Role Name should be informed"));
		}
 		return !result.hasErrors();
	}
	
}
