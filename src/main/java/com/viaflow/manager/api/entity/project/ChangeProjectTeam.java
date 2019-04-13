package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;

@Document
public class ChangeProjectTeam extends DTOBase {

	@Id
	private String changeProjectTeamId;

	@NotEmpty
	@DBRef
	private Team teamOld;

	@NotEmpty
	@DBRef
	private Team teamNew;

	@NotEmpty
	@DBRef
	private User changedUser;

	@NotEmpty
	@DBRef
	private Project project;

	public String getChangeProjectTeamId() {
		return changeProjectTeamId;
	}

	public void setChangeProjectTeamId(String changeProjectTeamId) {
		this.changeProjectTeamId = changeProjectTeamId;
	}

	public Team getTeamOld() {
		return teamOld;
	}

	public void setTeamOld(Team teamOld) {
		this.teamOld = teamOld;
	}

	public Team getTeamNew() {
		return teamNew;
	}

	public void setTeamNew(Team teamNew) {
		this.teamNew = teamNew;
	}

	public User getChangedUser() {
		return changedUser;
	}

	public void setChangedUser(User changedUser) {
		this.changedUser = changedUser;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ChangeProjectTeam [changeProjectTeamId=" + changeProjectTeamId + ", teamOld=" + teamOld + ", teamNew="
				+ teamNew + ", changedUser=" + changedUser + ", project=" + project + "]";
	}
}
