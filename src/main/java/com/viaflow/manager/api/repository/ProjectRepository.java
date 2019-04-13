package com.viaflow.manager.api.repository;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.viaflow.manager.api.entity.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String>{
	Page<Project> findByProjectTitleIgnoreCaseContaining(String projectTitle, Pageable pages);
	Page<Project> findByProjectUserUserId(String userId, Pageable pages);
	Page<Project> findByProjectStageProjectStageId(String projectStageId, Pageable pages);
	Page<Project> findByProjectStatusStatusId(String projectStatusId, Pageable pages);
	Page<Project> findByOwnerUserUserId(String userId, Pageable pages);
	Page<Project> findByOwnerTeamTeamId(String teamId, Pageable pages);
	Page<Project> findByProjectPriorityProjectPriorityId(String projectPriorityId, Pageable pages);	
	Page<Project> findByProjectContractContractId(String contractId, Pageable pages);
	Page<Project> findByProjectId (String projectId, Pageable page);
	Page<Project> findByProjectTypeProjectTypeId (String projectTypeId, Pageable page);
	Page<Project> findByProjectTitleOrProjectDescriptionOrProjectUserUserIdOrProjectDateOrProjectContractContractIdOrProjectTypeProjectTypeIdOrProjectStatusStatusIdOrProjectStageProjectStageIdOrProjectPriorityProjectPriorityIdOrOwnerUserUserIdOrOwnerTeamTeamId(
			String title, String description, String userId, Date date, String contractId, String projectTypeId,
			String statusId, String projectStageId, String projectPriorityId, String ownerUserId, String ownerTeamId,
			Pageable pages);
}
