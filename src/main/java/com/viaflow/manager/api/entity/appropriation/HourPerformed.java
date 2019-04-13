package com.viaflow.manager.api.entity.appropriation;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.user.User;

@Document
public class HourPerformed extends DTOBase {

	@Id
	private String hourPerformedId;

	@DBRef
	private Project project;

	@DBRef
	private User user;

	@NotEmpty
	private String hour;

	@NotEmpty
	private String description;

	public String getHourPerformedId() {
		return hourPerformedId;
	}

	public void setHourPerformedId(String hourPerformedId) {
		this.hourPerformedId = hourPerformedId;
	}

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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "HourPerformed [hourPerformedId=" + hourPerformedId + ", project=" + project + ", user=" + user
				+ ", hour=" + hour + ", description=" + description + "]";
	}
}
