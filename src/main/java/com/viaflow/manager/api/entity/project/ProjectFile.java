package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.model.AppFile;

@Document
public class ProjectFile extends DTOBase {

	@Id
	private String projectFileId;

	@NotEmpty
	@DBRef
	private Project project;

	@NotEmpty
	private AppFile projectFileAppFiles;

	public String getProjectFileId() {
		return projectFileId;
	}

	public void setProjectFileId(String projectFileId) {
		this.projectFileId = projectFileId;
	}

	public AppFile getProjectFile() {
		return projectFileAppFiles;
	}

	public void setProjectFile(AppFile projectFileAppFiles) {
		this.projectFileAppFiles = projectFileAppFiles;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
