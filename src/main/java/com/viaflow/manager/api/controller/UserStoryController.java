package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.us.UserStory;
import com.viaflow.manager.api.service.UserStoryService;
import com.viaflow.manager.api.validation.BaseValidation;


@RestController
@RequestMapping("/api/userstory")
@CrossOrigin(origins = "*")
public class UserStoryController extends BaseController<UserStory, UserStoryService, BaseValidation<UserStory>> {

	
	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private BaseValidation<UserStory> baseValidation;
	
	@Override
	protected UserStoryService getService() {	
		return this.userStoryService;
	}

	@Override
	protected BaseValidation<UserStory> getValidation() {
		return this.baseValidation;
	}

}