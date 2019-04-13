package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.viaflow.manager.api.entity.project.StatusPermissionByProfile;
import com.viaflow.manager.api.repository.StatusPermissionByProfileRepository;
import com.viaflow.manager.api.service.StatusPermissionByProfileService;

@Service
public class StatusPermissionByProfileServiceImpl extends BaseServiceImpl<StatusPermissionByProfile, StatusPermissionByProfileRepository> implements StatusPermissionByProfileService {

	@Autowired
	private StatusPermissionByProfileRepository statusPermissionByProfile;
	@Override
	protected StatusPermissionByProfileRepository getRepo() {
		
		return statusPermissionByProfile;
	}

}
