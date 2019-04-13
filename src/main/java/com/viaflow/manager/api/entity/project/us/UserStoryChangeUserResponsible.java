package com.viaflow.manager.api.entity.project.us;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class UserStoryChangeUserResponsible extends DTOBase {

	@Id
	private String userStoryChangeUserResponsibleId;

	private UserStory changeUserResponsible;

	private UserStory userStory;

	private UserStory newChangeUserResponsible;

	private UserStory userResponsibleForChange;

	public String getUserStoryChangeUserResponsibleId() {
		return userStoryChangeUserResponsibleId;
	}

	public void setUserStoryChangeUserResponsibleId(String userStoryChangeUserResponsibleId) {
		this.userStoryChangeUserResponsibleId = userStoryChangeUserResponsibleId;
	}

	public UserStory getChangeUserResponsible() {
		return changeUserResponsible;
	}

	public void setChangeUserResponsible(UserStory changeUserResponsible) {
		this.changeUserResponsible = changeUserResponsible;
	}

	public UserStory getNewChangeUserResponsible() {
		return newChangeUserResponsible;
	}

	public void setNewChangeUserResponsible(UserStory newChangeUserResponsible) {
		this.newChangeUserResponsible = newChangeUserResponsible;
	}

	public UserStory getUserResponsibleForChange() {
		return userResponsibleForChange;
	}

	public void setUserResponsibleForChange(UserStory userResponsibleForChange) {
		this.userResponsibleForChange = userResponsibleForChange;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	@Override
	public String toString() {
		return "UserStoryChangeUserResponsible [userStoryChangeUserResponsibleId=" + userStoryChangeUserResponsibleId
				+ ", changeUserResponsible=" + changeUserResponsible + ", userStory=" + userStory
				+ ", newChangeUserResponsible=" + newChangeUserResponsible + ", userResponsibleForChange="
				+ userResponsibleForChange + "]";
	}
}
