package com.viaflow.manager.api.entity.stage;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.ProjectType;

@Document
public class ProjectStagesVinculation extends DTOBase {

	@Id
	private String projectStagesVinculationId;

	@DBRef
	private ProjectType projectType;

	@DBRef
	private List<ProjectStage> projectStages;

	public String getProjectStagesVinculationId() {
		return projectStagesVinculationId;
	}

	public void setProjectStagesVinculationId(String projectStagesVinculationId) {
		this.projectStagesVinculationId = projectStagesVinculationId;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public List<ProjectStage> getProjectStages() {
		return projectStages;
	}

	public void setProjectStages(List<ProjectStage> projectStages) {
		this.projectStages = projectStages;
	}

	@Override
	public String toString() {
		return "ProjectStagesVinculation [projectStagesVinculationId=" + projectStagesVinculationId + ", projectType="
				+ projectType + ", ProjectStages=" + projectStages + "]";
	}

}
