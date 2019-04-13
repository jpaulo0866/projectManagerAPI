package com.viaflow.manager.api.model;

import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.stage.ProjectStage;

public class MoveProjectStage {
	
	private Project project;
	
	private ProjectStage projectStage;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectStage getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(ProjectStage projectStage) {
		this.projectStage = projectStage;
	}
	
	

}
