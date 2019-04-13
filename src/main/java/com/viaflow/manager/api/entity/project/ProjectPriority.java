package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class ProjectPriority extends DTOBase {

	@Id
	private String projectPriorityId;

	@Indexed(unique = true)
	@NotEmpty
	private String projectPriorityName;

	public String getProjectPriorityId() {
		return projectPriorityId;
	}

	public void setProjectPriorityId(String projectPriorityId) {
		this.projectPriorityId = projectPriorityId;
	}

	public String getProjectPriorityName() {
		return projectPriorityName;
	}

	public void setProjectPriorityName(String projectPriorityName) {
		this.projectPriorityName = projectPriorityName;
	}

	@Override
	public String toString() {
		return "ProjectPriority [projectPriorityId=" + projectPriorityId + ", projectPriorityName="
				+ projectPriorityName + "]";
	}

}