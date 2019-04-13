package com.viaflow.manager.api.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectStage;
import com.viaflow.manager.api.entity.project.ChangeProjectStatus;
import com.viaflow.manager.api.entity.project.ChangeProjectTeam;
import com.viaflow.manager.api.entity.project.ChangeProjectUser;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.entity.project.StatusPermissionByProfile;
import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.model.ChangeStatus;
import com.viaflow.manager.api.model.ChangeTeam;
import com.viaflow.manager.api.model.ChangeUser;
import com.viaflow.manager.api.model.MoveProjectStage;
import com.viaflow.manager.api.repository.ProjectRepository;
import com.viaflow.manager.api.service.ChangeProjectStageService;
import com.viaflow.manager.api.service.ChangeProjectStatusService;
import com.viaflow.manager.api.service.ChangeProjectTeamService;
import com.viaflow.manager.api.service.ChangeProjectUserService;
import com.viaflow.manager.api.service.ProjectService;
import com.viaflow.manager.api.service.ProjectStageService;
import com.viaflow.manager.api.service.StatusService;
import com.viaflow.manager.api.service.TeamService;
import com.viaflow.manager.api.service.UserService;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project, ProjectRepository> implements ProjectService {

	@Autowired
	private ProjectStageService projectStageService;

	@Autowired
	private ChangeProjectStageService changeProjectStageService;

	@Autowired
	private UserService userService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private ChangeProjectStatusService changeProjectStatusService;

	@Autowired
	private ChangeProjectUserService changeProjectUserService;

	@Autowired
	private ChangeProjectTeamService changeProjectTeamService;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	protected ProjectRepository getRepo() {
		return this.projectRepository;
	}

	public Project move(MoveProjectStage moveProjectStage, User user) {

		ProjectStage newStage = projectStageService.findById(moveProjectStage.getProjectStage().getProjectStageId());
		Project project = this.findById(moveProjectStage.getProject().getProjectId());
		ProjectStage oldStage = project.getProjectStage();
		project.setProjectStage(newStage);
		this.createOrUpdate(project);
		ChangeProjectStage changeProjectStage = new ChangeProjectStage();
		changeProjectStage.setChangedUser(user);
		changeProjectStage.setStageOld(oldStage);
		changeProjectStage.setStageNew(newStage);
		changeProjectStage.setProject(project);
		changeProjectStageService.createOrUpdate(changeProjectStage);

		return project;
	}

	public Project changeUser(ChangeUser changeUser, User user) {

		User newUser = userService.findById(changeUser.getUser().getUserId());
		Project project = this.findById(changeUser.getProject().getProjectId());
		User oldUser = project.getProjectUser();
		project.setOwnerUser(newUser);
		this.createOrUpdate(project);

		ChangeProjectUser changeProjectUser = new ChangeProjectUser();
		changeProjectUser.setUserNew(newUser);
		changeProjectUser.setUserOld(oldUser);
		changeProjectUser.setChangedUser(user);
		changeProjectUser.setProject(project);

		changeProjectUserService.createOrUpdate(changeProjectUser);

		return project;

	}

	public Project changeTeam(ChangeTeam changeTeam, User user) {

		Project project = this.findById(changeTeam.getProject().getProjectId());
		Team oldTeam = project.getOwnerTeam();
		Team newTeam = teamService.findById(changeTeam.getTeam().getTeamId());
		project.setOwnerTeam(newTeam);
		this.createOrUpdate(project);

		ChangeProjectTeam changeProjectTeam = new ChangeProjectTeam();
		changeProjectTeam.setChangedUser(user);
		changeProjectTeam.setTeamOld(oldTeam);
		changeProjectTeam.setTeamNew(newTeam);
		changeProjectTeam.setProject(project);

		this.changeProjectTeamService.createOrUpdate(changeProjectTeam);

		return project;
	}

	@Override
	public Project findById(String id) {
		Project project = this.getRepo().findById(id).get();
		project.setChangeProjectStages(
				changeProjectStageService.findByProjectProjectId(project.getProjectId()).getContent());
		project.setChangeProjectStatus(
				changeProjectStatusService.findByProjectProjectId(project.getProjectId()).getContent());
		project.setChangeProjectTeams(
				changeProjectTeamService.findByProjectProjectId(project.getProjectId()).getContent());
		project.setChangeProjectUsers(
				changeProjectUserService.findByProjectProjectId(project.getProjectId()).getContent());
		return project;
	}

	@Override
	public Page<Project> findByTitle(String title, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectTitleIgnoreCaseContaining(title, pages);
	}

	@Override
	public Page<Project> findByContractId(String contractId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectContractContractId(contractId, pages);
	}

	public Page<Project> findByProjectTypeId(String projectTypeId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectTypeProjectTypeId(projectTypeId, pages);
	}

	@Override
	public Page<Project> findByProjectId(String projectId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectId(projectId, pages);
	}

	public Project changeStatus(ChangeStatus changeStatus, User user) {

		Project project = this.findById(changeStatus.getProject().getProjectId());
		Status oldStatus = statusService.findById(project.getProjectStatus().getStatusId());
		Status newStatus = statusService.findById(changeStatus.getStatusProject().getStatusId());
		project.setProjectStatus(newStatus);
		this.createOrUpdate(project);

		ChangeProjectStatus changeProjectStatus = new ChangeProjectStatus();
		changeProjectStatus.setChangeProjectStatusUser(user);
		changeProjectStatus.setChangeProjectStatusNew(newStatus);
		changeProjectStatus.setChangeProjectStatusOld(oldStatus);

		this.changeProjectStatusService.createOrUpdate(changeProjectStatus);

		return project;
	}

	public Page<Project> findByUser(String userId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectUserUserId(userId, pages);
	}

	public Page<Project> findByProjectStage(String projectStageId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectStageProjectStageId(projectStageId, pages);
	}

	public Page<Project> findByProjectStatus(String projectStatusId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByProjectStatusStatusId(projectStatusId, pages);
	}

	@Override
	public Page<Project> findProjectsByOwnerUser(String userId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.projectRepository.findByOwnerUserUserId(userId, pages);
	}

	@Override
	public Page<Project> findProjectsByOwnerTeam(String teamId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.projectRepository.findByOwnerTeamTeamId(teamId, pages);
	}

	@Override
	public Page<Project> findProjectsByProjectPriority(String projectPriorityId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.projectRepository.findByProjectPriorityProjectPriorityId(projectPriorityId, pages);
	}

	public Project statusPermission(StatusPermissionByProfile statusPermissionByProfile) {
		return null;
	}

	@Override
	public Page<Project> findByMultiParams(String title, String description, String userId, Date date,
			String contractId, String projectTypeId, String statusId, String projectStageId, String projectPriorityId,
			String ownerUserId, String ownerTeamId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo()
				.findByProjectTitleOrProjectDescriptionOrProjectUserUserIdOrProjectDateOrProjectContractContractIdOrProjectTypeProjectTypeIdOrProjectStatusStatusIdOrProjectStageProjectStageIdOrProjectPriorityProjectPriorityIdOrOwnerUserUserIdOrOwnerTeamTeamId(
						title, description, userId, date, contractId, projectTypeId, statusId, projectStageId,
						projectPriorityId, ownerUserId, ownerTeamId, pages);
	}

}
