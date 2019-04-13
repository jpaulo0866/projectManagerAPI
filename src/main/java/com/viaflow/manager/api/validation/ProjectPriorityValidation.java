package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ProjectPriority;

@Component
public class ProjectPriorityValidation implements BaseValidation<ProjectPriority> {

	@Override
	public boolean validateObject(ProjectPriority object, BindingResult result) {
		if (object.getProjectPriorityName() == null
				|| object.getProjectPriorityName().isEmpty()) {
			result.addError(new ObjectError("Project Priority", "Field Project Priority Name should be informed"));
			}
		return !result.hasErrors();
		}

	}