package com.viaflow.manager.api.entity.curriculum;

import java.util.List;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ldap.odm.annotations.Id;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.model.AppFile;

@Document
public class CurriculumBase extends DTOBase {

	@Id
	private String curriculumBaseId;

	@TextIndexed
	private String candidateName;
	
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	private List<AppFile> curriculumFiles;

	public String getCurriculumBaseId() {
		return curriculumBaseId;
	}

	public void setCurriculumBaseId(String curriculumBaseId) {
		this.curriculumBaseId = curriculumBaseId;
	}

	public List<AppFile> getCurriculumFiles() {
		return curriculumFiles;
	}

	public void setCurriculumFiles(List<AppFile> curriculumFiles) {
		this.curriculumFiles = curriculumFiles;
	}

}
