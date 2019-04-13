package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectTeam;
import com.viaflow.manager.api.repository.ChangeProjectTeamRepository;
import com.viaflow.manager.api.service.ChangeProjectTeamService;

@Service
public class ChangeProjectTeamServiceImpl extends BaseServiceImpl<ChangeProjectTeam, ChangeProjectTeamRepository> implements ChangeProjectTeamService {

	@Autowired
	private ChangeProjectTeamRepository changeProjectTeam;
	
	@Override
	protected ChangeProjectTeamRepository getRepo() {
		return this.changeProjectTeam;
	}

	@Override
	public Page<ChangeProjectTeam> findByProjectProjectId(String projectId) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findByProjectProjectId(projectId, pages);
	}

}
