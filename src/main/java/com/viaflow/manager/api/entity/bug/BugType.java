package com.viaflow.manager.api.entity.bug;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class BugType extends DTOBase {

	@Id
	private String bugTypeId;

	@NotEmpty
	private String bugTypeName;

	public String getBugTypeId() {
		return bugTypeId;
	}

	public void setBugTypeId(String bugTypeId) {
		this.bugTypeId = bugTypeId;
	}

	public String getBugTypeName() {
		return bugTypeName;
	}

	public void setBugTypeName(String bugTypeName) {
		this.bugTypeName = bugTypeName;
	}

	@Override
	public String toString() {
		return "BugType [id=" + bugTypeId + ", nome=" + bugTypeName + "]";
	}
}
