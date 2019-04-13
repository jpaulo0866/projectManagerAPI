package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.permission.TypePermission;

@Component
public class TypePermissionValidation implements BaseValidation<TypePermission> {

	@Override
	public boolean validateObject(TypePermission object, BindingResult result) {
		if (object.getTypePermissionName() == null || object.getTypePermissionName().isEmpty()) {
			result.addError(new ObjectError("TypePermission", "Field Type Permission Name should be informed"));
		}
		return !result.hasErrors();
	}
}
