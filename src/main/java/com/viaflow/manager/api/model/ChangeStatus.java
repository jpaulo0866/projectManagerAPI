package com.viaflow.manager.api.model;

import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.project.Status;

public class ChangeStatus {
	
	private Status statusProject;
	
	private Project project;

	public Status getStatusProject() {
		return statusProject;
	}

	public void setStatusProject(Status statusProject) {
		this.statusProject = statusProject;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ChangeProjectStatus [statusProject=" + statusProject + ", project=" + project + "]";
	}
}