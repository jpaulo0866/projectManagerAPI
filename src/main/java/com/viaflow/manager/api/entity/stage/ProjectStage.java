package com.viaflow.manager.api.entity.stage;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class ProjectStage extends DTOBase {

	@Id
	private String projectStageId;

	@Indexed(unique = true)
	@NotEmpty
	private String projectStageName;

	private boolean disabled;

	public String getProjectStageId() {
		return projectStageId;
	}

	public void setProjectStageId(String projectStageId) {
		this.projectStageId = projectStageId;
	}

	public String getProjectStageName() {
		return projectStageName;
	}

	public void setProjectStageName(String projectStageName) {
		this.projectStageName = projectStageName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "ProjectStage [projectStageiD=" + projectStageId + ", projectStageName=" + projectStageName
				+ ", disabled=" + disabled + "]";
	}

}
