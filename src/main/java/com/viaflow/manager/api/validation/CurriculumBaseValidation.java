package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.curriculum.CurriculumBase;

@Component
public class CurriculumBaseValidation implements BaseValidation<CurriculumBase>{

	@Override
	public boolean validateObject(CurriculumBase object, BindingResult result) {
		
		if (object.getCandidateName() == null) {
			result.addError(new ObjectError("Curriculum Base", "Name should be informed"));
		}
		if (object.getCurriculumFiles() == null
				|| object.getCurriculumFiles().isEmpty()) {
			
			result.addError(new ObjectError("Curriculum Base", "File should be informed"));
		}
 		return !result.hasErrors();
	}

}
