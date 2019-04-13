package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectFile;
import com.viaflow.manager.api.repository.ProjectFileRepository;
import com.viaflow.manager.api.service.ProjectFileService;

@Service
public class ProjectFileServiceImpl extends BaseServiceImpl<ProjectFile, ProjectFileRepository> implements ProjectFileService{

	
	@Autowired
	private ProjectFileRepository projectFileRepository;
	
	@Override
	protected ProjectFileRepository getRepo() {
		
		return this.projectFileRepository;
	}

	public Page<ProjectFile> findByProjectFile(String projectFile, int page,int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectProjectId(projectFile, pages);
	}

}
