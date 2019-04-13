package com.viaflow.manager.api.model;

import java.util.List;

import com.viaflow.manager.api.entity.project.Project;

public class GenerateEstimate {
	
	private Project project;
	
	private String description;
	
	private List<String> guarantees;
	
	private List<String> preRequisites;
	
	private List<EstimateActivities> estimatedActivities;
	
	private List<String> activiesPerfomed;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getGuarantees() {
		return guarantees;
	}

	public void setGuarantees(List<String> guarantees) {
		this.guarantees = guarantees;
	}

	public List<String> getPreRequisites() {
		return preRequisites;
	}

	public void setPreRequisites(List<String> preRequisites) {
		this.preRequisites = preRequisites;
	}

	public List<EstimateActivities> getEstimatedActivities() {
		return estimatedActivities;
	}

	public void setEstimatedActivities(List<EstimateActivities> estimatedActivities) {
		this.estimatedActivities = estimatedActivities;
	}

	public List<String> getActiviesPerfomed() {
		return activiesPerfomed;
	}

	public void setActiviesPerfomed(List<String> activiesPerfomed) {
		this.activiesPerfomed = activiesPerfomed;
	}

	@Override
	public String toString() {
		return "GenerateEstimate [project=" + project + ", description=" + description + ", guarantees=" + guarantees
				+ ", preRequisites=" + preRequisites + ", estimatedActivities=" + estimatedActivities
				+ ", activiesPerfomed=" + activiesPerfomed + "]";
	}
}
