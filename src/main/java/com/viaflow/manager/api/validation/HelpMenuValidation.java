package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.help.HelpMenu;

@Component
public class HelpMenuValidation implements BaseValidation<HelpMenu> {

	@Override
	public boolean validateObject(HelpMenu object, BindingResult result) {
		
		if (object.getComponent() == null){
			result.addError(new ObjectError("Help Menu", "Component should be informed"));
		}
		if (object.getTemplateHTML() == null){
			result.addError(new ObjectError("Help Menu", "Template HTML should be informed"));
		}
 		return !result.hasErrors();
	}

}
