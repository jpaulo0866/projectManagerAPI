package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.employee.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	Role findRoleByRoleNameIgnoreCaseContaining(String roleName);
}