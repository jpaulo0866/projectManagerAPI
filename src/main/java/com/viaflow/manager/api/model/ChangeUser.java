package com.viaflow.manager.api.model;

import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.user.User;

public class ChangeUser {
	
	private Project project;
	
	private User user;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ChangeUser [project=" + project + "]";
	}
}
