package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ProjectComplexity;

@Component
public class ProjectComplexityValidation implements BaseValidation<ProjectComplexity> {

	@Override
	public boolean validateObject(ProjectComplexity object, BindingResult result) {
		if (object.getProjectComplexityName() == null
				|| object.getProjectComplexityName().isEmpty()) {
			result.addError(new ObjectError("Project Complexity", "Field Project complexity Name should be informed"));
		}
	
		return !result.hasErrors();
	}
	
		
}