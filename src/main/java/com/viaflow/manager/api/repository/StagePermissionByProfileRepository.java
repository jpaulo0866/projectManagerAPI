package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.StagePermissionByProfile;

@Repository
public interface StagePermissionByProfileRepository extends MongoRepository<StagePermissionByProfile, String>{

}
