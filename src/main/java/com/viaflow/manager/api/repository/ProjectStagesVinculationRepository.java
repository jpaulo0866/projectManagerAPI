package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.stage.ProjectStagesVinculation;

@Repository
public interface ProjectStagesVinculationRepository extends MongoRepository<ProjectStagesVinculation, String>{
	Page<ProjectStagesVinculation> findByProjectTypeProjectTypeId(String projectTypeId, Pageable page);

}
