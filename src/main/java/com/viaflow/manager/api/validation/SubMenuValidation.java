package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.component.SubMenu;


@Component
public class SubMenuValidation implements BaseValidation<SubMenu>{

	@Override
	public boolean validateObject(SubMenu object, BindingResult result) {
		if (object.getSubMenuName() == null
				|| object.getSubMenuName().isEmpty()) {
			result.addError(new ObjectError("SubMenu", "Field Name should be informed"));
		}
		if (object.getComponents() == null || object.getComponents().isEmpty()) {
			result.addError(new ObjectError("Sub Menus", "Field Components Item should be informed"));
		}

		return !result.hasErrors();
	}

}
