package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.model.ProjectFilter;

@Component
public class ProjectValidation implements BaseValidation<Project> {

	@Override
	public boolean validateObject(Project object, BindingResult result) {
		if (object.getProjectTitle() == null || object.getProjectTitle().isEmpty()) {
			result.addError(new ObjectError("Project", "Title should be informed"));
		}
		if (object.getProjectDescription() == null || object.getProjectDescription().isEmpty()) {
			result.addError(new ObjectError("Project", "Description should be informed"));
		}
		if (object.getProjectContract() == null) {
			result.addError(new ObjectError("Project", "Contract should be informed"));
		}
		if (object.getProjectType() == null) {
			result.addError(new ObjectError("Project", "Project Type should be informed"));
		}
		if (object.getProjectStatus() == null) {
			result.addError(new ObjectError("Project", "Status should be informed"));
		}
		if (object.getProjectPriority() == null) {
			result.addError(new ObjectError("Project", "Priority should be informed"));
		}
		return !result.hasErrors();
	}

	public boolean validateFilter(ProjectFilter objProject) {
		if (objProject.getTitle().equals("") && objProject.getDescription().equals("")
				&& objProject.getUserId().equals("") && objProject.getContractId().equals("")
				&& objProject.getProjectStageId().equals("") && objProject.getProjectPriorityId().equals("")
				&& objProject.getOwnerUserId().equals("") && objProject.getOwnerTeamId().equals("")
				&& objProject.getDate() == null) {
			return false;
		}
		return true;

	}

}
