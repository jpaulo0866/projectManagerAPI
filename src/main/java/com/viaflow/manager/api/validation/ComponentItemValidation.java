package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.component.ComponentItem;

@Component
public class ComponentItemValidation implements BaseValidation<ComponentItem> {

	@Override
	public boolean validateObject(ComponentItem object, BindingResult result) {
		if (object.getComponentItemIdHTML() == null || object.getComponentItemIdHTML().isEmpty()) {
			result.addError(new ObjectError("ComponentItem", "Field Item Html Name should be informed"));
		}
		if (object.getComponentValue() == null || object.getComponentValue().isEmpty()) {
			result.addError(new ObjectError("ComponentItem", "Field Component Value should be informed"));
		}
		if (object.getAppComponent() == null || object.getAppComponent().getComponentId().isEmpty()) {
			result.addError(new ObjectError("ComponentItem", "Field Components should be informed"));
		}
		return !result.hasErrors();
	}

}
