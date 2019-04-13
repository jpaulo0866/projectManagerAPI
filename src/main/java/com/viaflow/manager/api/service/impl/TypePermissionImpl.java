package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.permission.TypePermission;
import com.viaflow.manager.api.repository.TypePermissionRepository;
import com.viaflow.manager.api.service.TypePermissionService;

@Service
public class TypePermissionImpl extends BaseServiceImpl<TypePermission, TypePermissionRepository>
		implements TypePermissionService {

	@Autowired
	private TypePermissionRepository typePermissionRepository;

	@Override
	protected TypePermissionRepository getRepo() {
		return this.typePermissionRepository;
	}

	@Override
	public TypePermission findByTypePermissionName(String typePermissionName) {
		return this.getRepo().findByTypePermissionName(typePermissionName);
		}
}
