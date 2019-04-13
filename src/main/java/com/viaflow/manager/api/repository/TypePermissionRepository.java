package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.permission.TypePermission;

@Repository
public interface TypePermissionRepository extends MongoRepository<TypePermission, String> {
	TypePermission findByTypePermissionName(String typePermissionName);


}
