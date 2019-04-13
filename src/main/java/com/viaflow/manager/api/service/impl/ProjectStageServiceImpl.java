package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.repository.ProjectStageRepository;
import com.viaflow.manager.api.service.ProjectStageService;

@Service
public class ProjectStageServiceImpl extends BaseServiceImpl<ProjectStage, ProjectStageRepository> implements ProjectStageService {

	@Autowired
	private ProjectStageRepository projectStageRepository;
	
	@Override
	protected ProjectStageRepository getRepo() {
		return this.projectStageRepository;
	}

	@Override
	public Page<ProjectStage> findProjectStageByProjectStageNameIgnoreCaseContaining(String projectStageName, int page, int count) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findProjectStageByProjectStageNameIgnoreCaseContaining(projectStageName, pages);
	}

}
