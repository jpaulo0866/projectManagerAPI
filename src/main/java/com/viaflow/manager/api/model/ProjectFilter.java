package com.viaflow.manager.api.model;

import java.util.Date;

public class ProjectFilter {

	private String title;

	private String description;

	private String userId;

	private Date date;

	private String contractId;

	private String projectTypeId;

	private String statusId;

	private String projectStageId;

	private String projectPriorityId;

	private String ownerUserId;

	private String ownerTeamId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date long1) {
		this.date = long1;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getProjectStageId() {
		return projectStageId;
	}

	public void setProjectStageId(String projectStageId) {
		this.projectStageId = projectStageId;
	}

	public String getProjectPriorityId() {
		return projectPriorityId;
	}

	public void setProjectPriorityId(String projectPriorityId) {
		this.projectPriorityId = projectPriorityId;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getOwnerTeamId() {
		return ownerTeamId;
	}

	public void setOwnerTeamId(String ownerTeamId) {
		this.ownerTeamId = ownerTeamId;
	}

	

}
