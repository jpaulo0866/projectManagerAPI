package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.viaflow.manager.api.entity.project.us.UserStoryChangeResponsibleTeam;
import com.viaflow.manager.api.repository.UserStoryChangeResponsibleTeamRepository;
import com.viaflow.manager.api.service.UserStoryChangeResponsibleTeamService;

public class UserStoryChangeResponsibleTeamServiceImpl extends BaseServiceImpl<UserStoryChangeResponsibleTeam,UserStoryChangeResponsibleTeamRepository> implements UserStoryChangeResponsibleTeamService {

	@Autowired
	private UserStoryChangeResponsibleTeamRepository userStoryChangeResponsibleTeamRepository;
	
	
	
	@Override
	protected UserStoryChangeResponsibleTeamRepository getRepo() {
		return this.userStoryChangeResponsibleTeamRepository;
	}

}

