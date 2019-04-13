package com.viaflow.manager.api.entity.project.us;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.ChangeProjectUser;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.model.AppFile;

@Document
public class UserStory extends DTOBase {

	@Id
	private String userStoryId;

	@NotEmpty
	private String title;

	private String description;

	@DBRef
	private Status statusUs;

	@DBRef
	private Project project;

	@DBRef
	private User createUserStory;

	@DBRef
	private User responsibleUser;

	@DBRef
	private User usAlterUser;

	@DBRef
	private Team responsibleTeam;

	private List<ChangeProjectUser> changeUsers;

	private List<AppFile> appFiles;

	private List<UserStoryStatusChange> requirements;

	public Status getStatusUs() {
		return statusUs;
	}

	public void setStatusUs(Status statusUs) {
		this.statusUs = statusUs;
	}

	public String getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(String userStoryId) {
		this.userStoryId = userStoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return createUserStory;
	}

	public void setUser(User user) {
		this.createUserStory = user;
	}

	public User getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(User responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public Team getResponsibleTeam() {
		return responsibleTeam;
	}

	public void setResponsibleTeam(Team responsibleTeam) {
		this.responsibleTeam = responsibleTeam;
	}

	public List<ChangeProjectUser> getChangeUser() {
		return changeUsers;
	}

	public void setChangeUser(List<ChangeProjectUser> changeUser) {
		this.changeUsers = changeUser;
	}

	public List<AppFile> getAppFiles() {
		return appFiles;
	}

	public void setAppFiles(List<AppFile> appFiles) {
		this.appFiles = appFiles;
	}

	public List<UserStoryStatusChange> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<UserStoryStatusChange> requirements) {
		this.requirements = requirements;
	}

	@Override
	public String toString() {
		return "UserStory [userStoryId=" + userStoryId + ", title=" + title + ", description=" + description
				+ ", statusUs=" + statusUs + ", project=" + project + ", createUserStory=" + createUserStory
				+ ", responsibleUser=" + responsibleUser + ", usAlterUser=" + usAlterUser + ", responsibleTeam="
				+ responsibleTeam + ", changeUsers=" + changeUsers + ", appFiles=" + appFiles + ", requirements="
				+ requirements + "]";
	}
}