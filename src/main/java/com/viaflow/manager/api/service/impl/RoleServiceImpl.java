package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Role;
import com.viaflow.manager.api.repository.RoleRepository;
import com.viaflow.manager.api.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	protected RoleRepository getRepo() {
		return this.roleRepository;
	}

	@Override
	public Role findRoleByRoleNameIgnoreCaseContaining(String roleName) {
		return this.getRepo().findRoleByRoleNameIgnoreCaseContaining(roleName);
	}

}
