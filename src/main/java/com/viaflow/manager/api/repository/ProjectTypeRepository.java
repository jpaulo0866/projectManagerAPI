package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.ProjectType;

@Repository
public interface ProjectTypeRepository extends MongoRepository<ProjectType, String>{
	ProjectType findByProjectTypeNameIgnoreCaseContaining(String projectTypeName);
}
