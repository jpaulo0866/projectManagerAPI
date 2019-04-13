package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.component.Menu;

@Component
public class MenuValidation implements BaseValidation<Menu> {

	@Override
	public boolean validateObject(Menu object, BindingResult result) {

		if (object.getMenuName() == null
				|| object.getMenuName().isEmpty()) {
			result.addError(new ObjectError("Menu", "Field Name should be informed"));
		}
		
		return !result.hasErrors();
	}

}
