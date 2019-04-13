package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectPriority;
import com.viaflow.manager.api.repository.ProjectPriorityRepository;
import com.viaflow.manager.api.service.ProjectPriorityService;

@Service
public class ProjectPriorityServiceImpl extends BaseServiceImpl<ProjectPriority, ProjectPriorityRepository> implements ProjectPriorityService {

	@Autowired
	private ProjectPriorityRepository projectPriorityRepository;
	
	@Override
	protected ProjectPriorityRepository getRepo() {
		return this.projectPriorityRepository;
	}

}


