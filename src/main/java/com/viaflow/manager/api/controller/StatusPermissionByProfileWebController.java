package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.viaflow.manager.api.entity.project.StatusPermissionByProfile;
import com.viaflow.manager.api.service.StatusPermissionByProfileService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/status/permission")
@CrossOrigin("*")
public class StatusPermissionByProfileWebController extends BaseController<StatusPermissionByProfile, StatusPermissionByProfileService, BaseValidation<StatusPermissionByProfile>>{

	
	@Autowired
	private StatusPermissionByProfileService statusPermissionByProfile;
	
	@Autowired
	private BaseValidation<StatusPermissionByProfile> baseValidation;
	
	
	@Override
	protected StatusPermissionByProfileService getService() {
	
		return statusPermissionByProfile;
	}

	@Override
	protected BaseValidation<StatusPermissionByProfile> getValidation() {
		
		return baseValidation;
	}

}
