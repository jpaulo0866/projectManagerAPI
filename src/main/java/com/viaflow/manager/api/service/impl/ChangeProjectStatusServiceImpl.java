package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectStatus;
import com.viaflow.manager.api.repository.ChangeProjectStatusRepository;
import com.viaflow.manager.api.service.ChangeProjectStatusService;

@Service
public class ChangeProjectStatusServiceImpl extends BaseServiceImpl<ChangeProjectStatus, ChangeProjectStatusRepository> implements ChangeProjectStatusService {

	
	@Autowired
	private ChangeProjectStatusRepository changeProjectStatusRepository;
	
	@Override
	protected ChangeProjectStatusRepository getRepo() {
		
		return this.changeProjectStatusRepository;
		
	}

	@Override
	public Page<ChangeProjectStatus> findByProjectProjectId(String projectId) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findByProjectProjectId(projectId, pages);
	}


}
