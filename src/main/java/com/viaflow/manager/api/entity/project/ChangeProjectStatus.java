package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

@Document
public class ChangeProjectStatus extends DTOBase {

	@Id
	private String changeProjectStatusId;

	@NotEmpty
	@DBRef
	private Status changeProjectStatusOld;

	@NotEmpty
	@DBRef
	private Status changeProjectStatusNew;

	@NotEmpty
	@DBRef
	private User changeProjectStatusUser;

	@NotEmpty
	@DBRef
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getChangeProjectStatusId() {
		return changeProjectStatusId;
	}

	public void setChangeProjectStatusId(String changeProjectStatusId) {
		this.changeProjectStatusId = changeProjectStatusId;
	}

	public Status getChangeProjectStatusOld() {
		return changeProjectStatusOld;
	}

	public void setChangeProjectStatusOld(Status changeProjectStatusOld) {
		this.changeProjectStatusOld = changeProjectStatusOld;
	}

	public Status getChangeProjectStatusNew() {
		return changeProjectStatusNew;
	}

	public void setChangeProjectStatusNew(Status changeProjectStatusNew) {
		this.changeProjectStatusNew = changeProjectStatusNew;
	}

	public User getChangeProjectStatusUser() {
		return changeProjectStatusUser;
	}

	public void setChangeProjectStatusUser(User changeProjectStatusUser) {
		this.changeProjectStatusUser = changeProjectStatusUser;
	}

	@Override
	public String toString() {
		return "ChangeProjectStatus [changeProjectStatusId=" + changeProjectStatusId + ", changeProjectStatusOld="
				+ changeProjectStatusOld + ", changeProjectStatusNew=" + changeProjectStatusNew
				+ ", changeProjectStatusUser=" + changeProjectStatusUser + ", project=" + project + "]";
	}
}
