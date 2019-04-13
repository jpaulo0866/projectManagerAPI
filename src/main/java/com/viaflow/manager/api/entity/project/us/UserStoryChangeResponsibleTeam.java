package com.viaflow.manager.api.entity.project.us;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;

@Document
public class UserStoryChangeResponsibleTeam extends DTOBase {

	@Id
	private String UserStoryChangeResponsibleTeamId;

	private UserStory us;

	private Team previousTeam;

	private Team newTeam;

	private User changeTeam;

	public String getUserStoryChangeResponsibleTeamId() {
		return UserStoryChangeResponsibleTeamId;
	}

	public void setUserStoryChangeResponsibleTeamId(String userStoryChangeResponsibleTeamId) {
		UserStoryChangeResponsibleTeamId = userStoryChangeResponsibleTeamId;
	}

	public UserStory getUs() {
		return us;
	}

	public void setUs(UserStory us) {
		this.us = us;
	}

	public Team getPreviousTeam() {
		return previousTeam;
	}

	public void setPreviousTeam(Team previousTeam) {
		this.previousTeam = previousTeam;
	}

	public Team getNewTeam() {
		return newTeam;
	}

	public void setNewTeam(Team newTeam) {
		this.newTeam = newTeam;
	}

	public User getChangeTeam() {
		return changeTeam;
	}

	public void setChangeTeam(User changeTeam) {
		this.changeTeam = changeTeam;
	}

	@Override
	public String toString() {
		return "UserStoryChangeResponsibleTeam [UserStoryChangeResponsibleTeamId=" + UserStoryChangeResponsibleTeamId
				+ ", us=" + us + ", previousTeam=" + previousTeam + ", newTeam=" + newTeam + ", changeTeam="
				+ changeTeam + "]";
	}
}