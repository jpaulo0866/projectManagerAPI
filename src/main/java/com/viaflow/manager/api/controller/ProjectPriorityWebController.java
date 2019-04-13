package com.viaflow.manager.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.ProjectPriority;
import com.viaflow.manager.api.service.ProjectPriorityService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/projectpriority")
@CrossOrigin("*")
public class ProjectPriorityWebController extends BaseController<ProjectPriority, ProjectPriorityService, BaseValidation<ProjectPriority>> {

	@Autowired
	private ProjectPriorityService projectPriorityService;
	
	@Autowired
	private BaseValidation<ProjectPriority> baseValidation;
	
	@Override
	protected ProjectPriorityService getService() {
		return this.projectPriorityService;
	}

	@Override
	protected BaseValidation<ProjectPriority> getValidation() {
		return this.baseValidation;
	}

}


