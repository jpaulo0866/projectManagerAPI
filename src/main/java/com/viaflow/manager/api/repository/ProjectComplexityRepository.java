package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.ProjectComplexity;

@Repository
public interface ProjectComplexityRepository extends MongoRepository<ProjectComplexity, String> {
	ProjectComplexity findByProjectComplexityNameIgnoreCase(String projectComplexityName);
}


