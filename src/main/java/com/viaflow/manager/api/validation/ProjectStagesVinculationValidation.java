package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.stage.ProjectStagesVinculation;

@Component
public class ProjectStagesVinculationValidation implements BaseValidation<ProjectStagesVinculation>{

	@Override
	public boolean validateObject(ProjectStagesVinculation object, BindingResult result) {
		if (object.getProjectType() == null) {
			
			result.addError(new ObjectError("Project Type", "Project type Name should be informed"));
		}
		if (object.getProjectStages() == null ||
				object.getProjectStages().isEmpty()) {
			
			result.addError(new ObjectError("Project Type", "Project type Name should be informed"));
		}
 		return !result.hasErrors();
	}

}
