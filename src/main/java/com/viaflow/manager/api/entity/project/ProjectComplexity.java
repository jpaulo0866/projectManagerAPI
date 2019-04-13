package com.viaflow.manager.api.entity.project;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class ProjectComplexity extends DTOBase {

	@Id
	private String projectComplexityId;

	@Indexed(unique = true)
	@NotEmpty
	private String projectComplexityName;

	@NotEmpty
	private double projectComplexityHours;

	@NotEmpty
	private double projectComplexityCost;

	public String getProjectComplexityId() {
		return projectComplexityId;
	}

	public void setProjectComplexityId(String projectComplexityId) {
		this.projectComplexityId = projectComplexityId;
	}

	public String getProjectComplexityName() {
		return projectComplexityName;
	}

	public void setProjectComplexityName(String projectComplexityName) {
		this.projectComplexityName = projectComplexityName;
	}

	public double getProjectComplexityHours() {
		return projectComplexityHours;
	}

	public void setProjectComplexityHours(double projectComplexityHours) {
		this.projectComplexityHours = projectComplexityHours;
	}

	public double getProjectComplexityCost() {
		return projectComplexityCost;
	}

	public void setProjectComplexityCost(double projectComplexityCost) {
		this.projectComplexityCost = projectComplexityCost;
	}

	@Override
	public String toString() {
		return "ProjectComplexity [projectComplexityId=" + projectComplexityId + ", projectComplexityName="
				+ projectComplexityName + ", projectComplexityHours=" + projectComplexityHours
				+ ", projectComplexityCost=" + projectComplexityCost + "]";
	}

}
