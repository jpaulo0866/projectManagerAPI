package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.viaflow.manager.api.entity.project.ChangeProjectStatus;

public interface ChangeProjectStatusRepository extends MongoRepository<ChangeProjectStatus, String>{
	Page<ChangeProjectStatus> findByProjectProjectId(String projectId, Pageable page);
}
