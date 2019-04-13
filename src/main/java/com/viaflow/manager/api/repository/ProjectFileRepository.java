package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.ProjectFile;

@Repository
public interface ProjectFileRepository extends MongoRepository<ProjectFile, String>{

	Page<ProjectFile> findByProjectProjectId(String projectId, Pageable page);

}
