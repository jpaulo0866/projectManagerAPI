package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.model.Template;

@Component
public class TemplateValidation implements BaseValidation<Template>{

	@Override
	public boolean validateObject(Template object, BindingResult result) {

		if (object.getTemplateData() == null
				|| object.getTemplateData().isEmpty()) {
			result.addError(new ObjectError("Template", "Template should be informed"));
		}
 		return !result.hasErrors();
	}

}
