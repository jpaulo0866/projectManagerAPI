package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.permission.Permission;
import com.viaflow.manager.api.repository.PermissionRepository;
import com.viaflow.manager.api.service.PermissionService;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionRepository> implements PermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	protected PermissionRepository getRepo() {
		return this.permissionRepository;
	}

	@Override
	public Permission findByPermissionNameIgnoreCase(String permissionName) {
		return this.permissionRepository.findByPermissionNameIgnoreCase(permissionName);
	}

	@Override
	public Permission findByProfileProfileIdIgnoreCase(String profileId) {
		return this.permissionRepository.findByProfileProfileIdIgnoreCase(profileId);
	}
	

}
