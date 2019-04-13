package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectTeam;

@Service
public interface ChangeProjectTeamService extends BaseService<ChangeProjectTeam> {
	Page<ChangeProjectTeam> findByProjectProjectId(String projectId);

}
