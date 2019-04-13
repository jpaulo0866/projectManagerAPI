package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

@Document
public class ChangeProjectUser extends DTOBase {
	@Id
	private String changeProjectUserId;

	@NotEmpty
	@DBRef
	private User userOld;

	@NotEmpty
	@DBRef
	private User userNew;

	@NotEmpty
	@DBRef
	private User changedUser;

	@NotEmpty
	@DBRef
	private Project project;

	public String getChangeProjectUserId() {
		return changeProjectUserId;
	}

	public void setChangeProjectUserId(String changeProjectUserId) {
		this.changeProjectUserId = changeProjectUserId;
	}

	public User getUserOld() {
		return userOld;
	}

	public void setUserOld(User userOld) {
		this.userOld = userOld;
	}

	public User getUserNew() {
		return userNew;
	}

	public void setUserNew(User userNew) {
		this.userNew = userNew;
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
		return "ChangeProjectUser [changeProjectUserId=" + changeProjectUserId + ", userOld=" + userOld + ", userNew="
				+ userNew + ", changedUser=" + changedUser + ", project=" + project + "]";
	}
}
