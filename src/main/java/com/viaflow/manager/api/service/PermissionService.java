package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.permission.Permission;

@Service
public interface PermissionService extends BaseService<Permission>{
	Permission findByPermissionNameIgnoreCase(String permissionName);
	Permission findByProfileProfileIdIgnoreCase(String profileId);
}
