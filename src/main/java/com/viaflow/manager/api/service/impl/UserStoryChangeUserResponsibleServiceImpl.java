package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.us.UserStoryChangeUserResponsible;
import com.viaflow.manager.api.repository.UserStoryChangeUserResponsibleRepository;
import com.viaflow.manager.api.service.UserStoryChangeUserResponsibleService;

@Service
public class UserStoryChangeUserResponsibleServiceImpl extends BaseServiceImpl<UserStoryChangeUserResponsible, UserStoryChangeUserResponsibleRepository>implements UserStoryChangeUserResponsibleService {

	@Autowired
	private UserStoryChangeUserResponsibleRepository UserStoryChangeUserResponsibleRepository;
	

	protected UserStoryChangeUserResponsibleRepository getRepo() {
		return this.UserStoryChangeUserResponsibleRepository;
	}

}
