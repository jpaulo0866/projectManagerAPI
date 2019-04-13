package com.viaflow.manager.api.entity.bug;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.us.UserStory;

@Document
public class Bug extends DTOBase {

	@Id
	private String bugId;

	@NotEmpty
	private BugType bugType;

	@NotEmpty
	private String description;

	@NotEmpty
	private User user;

	@NotEmpty
	private User userResponse;

	@NotEmpty
	private UserStory userStory;

	private boolean resolvido;

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	public BugType getBugType() {
		return bugType;
	}

	public void setBugType(BugType bugType) {
		this.bugType = bugType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(User userResponse) {
		this.userResponse = userResponse;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}

	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", bugType=" + bugType + ", description=" + description + ", user=" + user
				+ ", userResponse=" + userResponse + ", userStory=" + userStory + ", resolvido=" + resolvido + "]";
	}
}
