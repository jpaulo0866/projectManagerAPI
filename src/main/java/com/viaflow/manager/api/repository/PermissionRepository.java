package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.permission.Permission;

@Repository
public interface PermissionRepository extends MongoRepository<Permission, String>{
	Permission findByPermissionNameIgnoreCase(String permissionName);
	Permission findByProfileProfileIdIgnoreCase(String profileId);
}
