package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.component.AppComponent;

@Component
public class AppComponentValidation implements BaseValidation<AppComponent> {

	@Override
	public boolean validateObject(AppComponent object, BindingResult result) {
		if (object.getComponentName() == null
				|| object.getComponentName().isEmpty()) {
			result.addError(new ObjectError("Component", "Field Name should be informed"));
		}
		if(object.getRouterLink() == null 
				|| object.getRouterLink().isEmpty()) {
			result.addError(new ObjectError("Component", "Field RouterLink should be informed"));
		}
		return !result.hasErrors();
	}

}
