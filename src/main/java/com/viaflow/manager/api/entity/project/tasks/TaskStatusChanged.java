package com.viaflow.manager.api.entity.project.tasks;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Status;

@Document
public class TaskStatusChanged extends DTOBase {

	@Id
	private String taskStatusId;

	@DBRef
	private Status newStatusTask;

	@DBRef
	private Status oldStatusTask;

	public String getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(String taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public Status getNewStatusTask() {
		return newStatusTask;
	}

	public void setNewStatusTask(Status newStatusTask) {
		this.newStatusTask = newStatusTask;
	}

	public Status getOldStatusTask() {
		return oldStatusTask;
	}

	public void setOldStatusTask(Status oldStatusTask) {
		this.oldStatusTask = oldStatusTask;
	}

	@Override
	public String toString() {
		return "TaskStatusChanged [taskStatusId=" + taskStatusId + ", newStatusTask=" + newStatusTask
				+ ", oldStatusTask=" + oldStatusTask + "]";
	}
}
