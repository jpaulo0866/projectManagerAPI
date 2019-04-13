package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.viaflow.manager.api.entity.project.ProjectType;

@Component
public class ProjectTypeValidation implements BaseValidation<ProjectType>{

	@Override
	public boolean validateObject(ProjectType object, BindingResult result) {
		if (object.getProjectTypeName() == null
				|| object.getProjectTypeName().isEmpty()) {
			result.addError(new ObjectError("Project Type", "Project Type Name type should be informed"));
		}
 		return !result.hasErrors();
	}

}
