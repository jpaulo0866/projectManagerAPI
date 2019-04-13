package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.stage.ProjectStage;

@Component
public class ProjectStageValidation implements BaseValidation<ProjectStage>{

	@Override
	public boolean validateObject(ProjectStage object, BindingResult result) {
		if (object.getProjectStageName() == null
				|| object.getProjectStageName().isEmpty()) {
			result.addError(new ObjectError("Project Stages", "Project Stage Name should be informed"));
		}
 		return !result.hasErrors();
	}

}

