package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.employee.Role;

@Service
public interface RoleService extends BaseService<Role>{
	Role findRoleByRoleNameIgnoreCaseContaining(String roleName);
}
