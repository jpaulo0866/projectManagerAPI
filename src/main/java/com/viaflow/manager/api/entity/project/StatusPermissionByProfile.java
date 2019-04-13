package com.viaflow.manager.api.entity.project;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.Profile;

@Document
public class StatusPermissionByProfile extends DTOBase {

	@Id
	private String statusPermissionByProfileId;

	@DBRef
	private Status status;

	@DBRef
	private List<Profile> profiles;

	public String getStatusPermissionByProfileId() {
		return statusPermissionByProfileId;
	}

	public void setStatusPermissionByProfileId(String statusPermissionByProfileId) {
		this.statusPermissionByProfileId = statusPermissionByProfileId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

}
