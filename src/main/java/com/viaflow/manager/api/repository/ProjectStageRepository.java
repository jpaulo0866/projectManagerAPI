package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.stage.ProjectStage;

@Repository
public interface ProjectStageRepository extends MongoRepository<ProjectStage, String> {
	Page<ProjectStage> findProjectStageByProjectStageNameIgnoreCaseContaining(String projectStageName, Pageable page);

}
