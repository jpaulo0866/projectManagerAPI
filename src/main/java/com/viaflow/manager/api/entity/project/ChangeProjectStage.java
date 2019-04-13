package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.entity.user.User;

@Document
public class ChangeProjectStage extends DTOBase {

	@Id
	private String changeProjectStageId;

	@NotEmpty
	@DBRef
	private ProjectStage stageOld;

	@NotEmpty
	@DBRef
	private ProjectStage stageNew;

	@NotEmpty
	@DBRef
	private User changedUser;

	@NotEmpty
	@DBRef
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getChangeProjectStageId() {
		return changeProjectStageId;
	}

	public void setChangeProjectStageId(String changeProjectStageId) {
		this.changeProjectStageId = changeProjectStageId;
	}

	public ProjectStage getStageOld() {
		return stageOld;
	}

	public void setStageOld(ProjectStage stageOld) {
		this.stageOld = stageOld;
	}

	public ProjectStage getStageNew() {
		return stageNew;
	}

	public void setStageNew(ProjectStage stageNew) {
		this.stageNew = stageNew;
	}

	public User getChangedUser() {
		return changedUser;
	}

	public void setChangedUser(User changedUser) {
		this.changedUser = changedUser;
	}
	@Override
	public String toString() {
		return "ChangeProjectStage [changeProjectStageId=" + changeProjectStageId + ", stageOld=" + stageOld
				+ ", stageNew=" + stageNew + ", changedUser=" + changedUser + ", project=" + project + "]";
	}
}
