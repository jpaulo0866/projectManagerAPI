package com.viaflow.manager.api.entity.project;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.entity.user.Profile;

@Document
public class StagePermissionByProfile extends DTOBase {

	@Id
	private String StagePermissionByProfileId;

	@DBRef
	private ProjectStage projectStage;

	@DBRef
	private List<Profile> profiles;

	public String getStagePermissionByProfileId() {
		return StagePermissionByProfileId;
	}

	public void setStagePermissionByProfileId(String stagePermissionByProfileId) {
		StagePermissionByProfileId = stagePermissionByProfileId;
	}

	public ProjectStage getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(ProjectStage projectStage) {
		this.projectStage = projectStage;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}
