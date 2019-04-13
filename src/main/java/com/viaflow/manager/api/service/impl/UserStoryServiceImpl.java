package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.us.UserStory;
import com.viaflow.manager.api.repository.UserStoryRepository;
import com.viaflow.manager.api.service.UserStoryService;

@Service
public class UserStoryServiceImpl extends  BaseServiceImpl<UserStory, UserStoryRepository> implements UserStoryService{

	@Autowired
	private UserStoryRepository userStoryRepository;
	
	@Override
	protected UserStoryRepository getRepo() {
		return this.userStoryRepository;
	}
	

}

