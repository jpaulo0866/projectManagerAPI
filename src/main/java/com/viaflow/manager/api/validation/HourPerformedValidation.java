package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.viaflow.manager.api.entity.appropriation.HourPerformed;

@Component
public class HourPerformedValidation implements BaseValidation<HourPerformed>  {
	
	@Override
	public boolean validateObject(HourPerformed object, BindingResult result) {
		if (object.getProject() == null) {
			result.addError(new ObjectError("HourPerformed", "Field Project should be informed"));
		}
		if (object.getUser() == null) {
			result.addError(new ObjectError("HourPerformed", "Field User should be informed"));
		}
		if(object.getHour() == null 
				|| object.getHour().isEmpty()) {
			result.addError(new ObjectError("HourPerformed", "Field Hour should be informed"));
		}
		if(object.getDescription() == null || object.getDescription().isEmpty()) {
			result.addError(new ObjectError("HourPerformed", "Field Description should be informed"));
		}
		return !result.hasErrors();
	}

}
