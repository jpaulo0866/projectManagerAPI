package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.permission.Permission;

@Component
public class PermissionValidation implements BaseValidation<Permission>{

	@Override
	public boolean validateObject(Permission object, BindingResult result) {
		if (object.getPermissionName() == null
				|| object.getPermissionName().isEmpty()) {
			result.addError(new ObjectError("Permission", "Field Permission Name should be informed"));
		}
		if(object.getComponents() == null 
				|| object.getComponents().isEmpty()) {
			result.addError(new ObjectError("Permission", "Field Components should be informed"));
		}
		if(object.getSubMenus() == null
				|| object.getSubMenus().isEmpty()) {
			result.addError(new ObjectError("Permission", "Field SubMenu Item should be informed"));
		}
		if(object.getMenus() == null 
				|| object.getMenus().isEmpty()) {
			result.addError( new ObjectError("Permission", "Field Menus should be informed"));
		}		
		if(object.getProfile() == null
				|| object.getProfile().getProfileId().isEmpty()) {
			result.addError(new ObjectError("Permission", "Field Profile should be informed"));
		}
		return !result.hasErrors();
	}
}
