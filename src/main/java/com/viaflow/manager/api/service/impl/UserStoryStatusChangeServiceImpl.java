package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.us.UserStoryStatusChange;
import com.viaflow.manager.api.repository.UserStoryStatusChangeRepository;
import com.viaflow.manager.api.service.UserStoryStatusChangeService;

@Service
public class UserStoryStatusChangeServiceImpl extends BaseServiceImpl<UserStoryStatusChange, UserStoryStatusChangeRepository> implements UserStoryStatusChangeService {

	
	@Autowired
	private  UserStoryStatusChangeRepository userStoryStatusChangeRepository;
	@Override
	protected UserStoryStatusChangeRepository getRepo() {
		return this.userStoryStatusChangeRepository;
	}

}

