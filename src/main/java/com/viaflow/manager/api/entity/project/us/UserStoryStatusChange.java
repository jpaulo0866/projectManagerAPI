package com.viaflow.manager.api.entity.project.us;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.entity.user.User;

@Document
public class UserStoryStatusChange extends DTOBase {

	@Id
	private String UserStoryChange;

	@NotEmpty
	private UserStory us;

	@NotEmpty
	private Status newStatusUs;

	@NotEmpty
	private Status oldStatusUs;

	@NotEmpty
	private User userThatChanged;

	public String getUserStoryChange() {
		return UserStoryChange;
	}

	public void setUserStoryChange(String userStoryChange) {
		UserStoryChange = userStoryChange;
	}

	public UserStory getUs() {
		return us;
	}

	public void setUs(UserStory us) {
		this.us = us;
	}

	public Status getNewStatusUs() {
		return newStatusUs;
	}

	public void setNewStatusUs(Status newStatusUs) {
		this.newStatusUs = newStatusUs;
	}

	public Status getOldStatusUs() {
		return oldStatusUs;
	}

	public void setOldStatusUs(Status oldStatusUs) {
		this.oldStatusUs = oldStatusUs;
	}

	public User getUserThatChanged() {
		return userThatChanged;
	}

	public void setUserThatChanged(User userThatChanged) {
		this.userThatChanged = userThatChanged;
	}

	@Override
	public String toString() {
		return "UserStoryStatusChange [UserStoryChange=" + UserStoryChange + ", us=" + us + ", newStatusUs="
				+ newStatusUs + ", oldStatusUs=" + oldStatusUs + ", userThatChanged=" + userThatChanged + "]";
	}
}
