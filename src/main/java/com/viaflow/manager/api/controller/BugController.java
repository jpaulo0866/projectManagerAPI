package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.bug.Bug;
import com.viaflow.manager.api.service.BugService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/bug")
@CrossOrigin(origins="*")
public class BugController extends BaseController<Bug, BugService, BaseValidation<Bug>> {

	@Autowired
	private BugService bugService;
	
	@Autowired
	private BaseValidation<Bug> bugValidation;
	
	@Override
	protected BugService getService() {
		return this.bugService;
	}

	@Override
	protected BaseValidation<Bug> getValidation() {
		return this.bugValidation;
	}

}
