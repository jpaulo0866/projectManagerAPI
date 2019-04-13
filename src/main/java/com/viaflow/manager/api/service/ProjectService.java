package com.viaflow.manager.api.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.project.StatusPermissionByProfile;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.model.ChangeStatus;
import com.viaflow.manager.api.model.ChangeTeam;
import com.viaflow.manager.api.model.ChangeUser;
import com.viaflow.manager.api.model.MoveProjectStage;

@Service
public interface ProjectService extends BaseService<Project>{
	Project move(MoveProjectStage moveProjectStage, User user);
	Project changeUser(ChangeUser changeUser, User user);
	Project changeTeam(ChangeTeam changeTeam, User user);
	Project changeStatus(ChangeStatus changeStatus, User user);
	Page<Project> findByTitle(String projectTitle, int page, int count);
	Page<Project> findByUser(String userId, int page, int count);
	Page<Project> findByProjectStage(String projectStageId, int page, int count);
	Page<Project> findByProjectStatus(String projectStatusId, int page, int count);
	Page<Project> findProjectsByOwnerUser(String userId, int page, int count);
	Page<Project> findProjectsByOwnerTeam(String teamId, int page, int count);
	Page<Project> findProjectsByProjectPriority(String projectPriorityId, int page, int count);
	Page<Project> findByContractId(String contractId, int page, int count);
	Page<Project> findByProjectTypeId(String projectTypeId, int page, int count);
	Page<Project> findByProjectId(String projectId, int page, int count);
	Project statusPermission(StatusPermissionByProfile statusPermissionByProfile);
	Page<Project> findByMultiParams(String title, String description, String userId, Date date, String contractId, String projectTypeId,
			String statusId, String projectStageId, String projectPriorityId, String ownerUserId, String ownerTeamId, int page, int count);
}