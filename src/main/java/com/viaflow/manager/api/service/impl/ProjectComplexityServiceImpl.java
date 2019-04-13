package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectComplexity;
import com.viaflow.manager.api.repository.ProjectComplexityRepository;
import com.viaflow.manager.api.service.ProjectComplexityService;

@Service
public class ProjectComplexityServiceImpl extends BaseServiceImpl<ProjectComplexity, ProjectComplexityRepository> implements ProjectComplexityService {

	@Autowired
	private ProjectComplexityRepository projectComplexityRepository;
	
	@Override
	protected ProjectComplexityRepository getRepo() {
		return this.projectComplexityRepository;
	}

	@Override
	public ProjectComplexity findByProjectComplexityName(String projectComplexityName) {
		return this.getRepo().findByProjectComplexityNameIgnoreCase(projectComplexityName);
	}

}


