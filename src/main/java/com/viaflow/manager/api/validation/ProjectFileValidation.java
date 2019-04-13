package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.ProjectFile;

@Component
public class ProjectFileValidation implements BaseValidation<ProjectFile>{

	@Override
	public boolean validateObject(ProjectFile object, BindingResult result) {
		
		if(object.getProject()==null) {
			result.addError(new ObjectError("Project File", "Field Project File should be informed"));
		}
		if(object.getProjectFile()==null) {
			result.addError(new ObjectError("Project File", "Field Project should be informed"));
		}
		return !result.hasErrors();
	}

}
