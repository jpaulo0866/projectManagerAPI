package com.viaflow.manager.api.model;

import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.user.Team;

public class ChangeTeam {
	
	private Team team;
	
	private Project project;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ChangeTeam [team=" + team + ", project=" + project + "]";
	}
}
