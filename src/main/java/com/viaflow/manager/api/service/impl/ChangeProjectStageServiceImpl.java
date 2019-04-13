package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectStage;
import com.viaflow.manager.api.repository.ChangeProjectStageRepository;
import com.viaflow.manager.api.service.ChangeProjectStageService;

@Service
public class ChangeProjectStageServiceImpl extends BaseServiceImpl<ChangeProjectStage, ChangeProjectStageRepository> implements ChangeProjectStageService {

	@Autowired
	private ChangeProjectStageRepository changeProjectStage;

	@Override
	protected ChangeProjectStageRepository getRepo() {
		return this.changeProjectStage;
	}

	@Override
	public Page<ChangeProjectStage> findByProjectProjectId(String projectId) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findByProjectProjectId(projectId, pages);
	}

}
