package com.viaflow.manager.api.entity.project.tasks;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.entity.project.us.UserStory;
import com.viaflow.manager.api.entity.user.User;

@Document
public class Task extends DTOBase {

	@Id
	private String projectTaskId;

	@NotEmpty
	private String projectTaskTitle;

	@NotEmpty
	private String projectTaskDescription;

	@DBRef
	private UserStory responsibleUserTask;

	@DBRef
	private User userCreatedTask;

	@DBRef
	private Status taskStatus;

	public String getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(String projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public String getProjectTaskTitle() {
		return projectTaskTitle;
	}

	public void setProjectTaskTitle(String projectTaskTitle) {
		this.projectTaskTitle = projectTaskTitle;
	}

	public String getProjectTaskDescription() {
		return projectTaskDescription;
	}

	public void setProjectTaskDescription(String projectTaskDescription) {
		this.projectTaskDescription = projectTaskDescription;
	}

	public UserStory getResponsibleUserTask() {
		return responsibleUserTask;
	}

	public void setResponsibleUserTask(UserStory responsibleUserTask) {
		this.responsibleUserTask = responsibleUserTask;
	}

	public User getUserCreatedTask() {
		return userCreatedTask;
	}

	public void setUserCreatedTask(User userCreatedTask) {
		this.userCreatedTask = userCreatedTask;
	}

	public Status getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Status taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "Task [projectTaskId=" + projectTaskId + ", projectTaskTitle=" + projectTaskTitle
				+ ", projectTaskDescription=" + projectTaskDescription + ", responsibleUserTask=" + responsibleUserTask
				+ ", userCreatedTask=" + userCreatedTask + ", taskStatus=" + taskStatus + "]";
	}
}
