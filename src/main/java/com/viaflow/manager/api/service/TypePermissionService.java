package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.permission.TypePermission;

@Service
public interface TypePermissionService extends BaseService<TypePermission> {
	TypePermission findByTypePermissionName(String typePermissionName);


}
