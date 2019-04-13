package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.ChangeProjectTeam;

@Repository
public interface ChangeProjectTeamRepository extends MongoRepository<ChangeProjectTeam, String>{
	Page<ChangeProjectTeam> findByProjectProjectId(String projectId, Pageable page);

}
