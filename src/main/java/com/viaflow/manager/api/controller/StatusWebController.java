package com.viaflow.manager.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.service.StatusService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/status")
@CrossOrigin("*")
public class StatusWebController extends BaseController<Status, StatusService, BaseValidation<Status>> {

	@Autowired
	private StatusService projectStatusService;
	
	@Autowired
	private BaseValidation<Status> baseValidation;
	
	@Override
	protected StatusService getService() {
		return this.projectStatusService;
	}

	@Override
	protected BaseValidation<Status> getValidation() {
		return this.baseValidation;
	}

}
