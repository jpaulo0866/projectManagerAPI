package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectType;
import com.viaflow.manager.api.repository.ProjectTypeRepository;
import com.viaflow.manager.api.service.ProjectTypeService;

@Service
public class ProjectTypeServiceImpl extends BaseServiceImpl<ProjectType, ProjectTypeRepository> implements ProjectTypeService{

	@Autowired
	private ProjectTypeRepository projectTypeRepository;
	
	@Override
	protected ProjectTypeRepository getRepo() {
		return this.projectTypeRepository;
	}

	@Override
	public ProjectType findByProjectTypeNameIgnoreCase(String projectTypeName) {
		return this.projectTypeRepository.findByProjectTypeNameIgnoreCaseContaining(projectTypeName);
	}

}
