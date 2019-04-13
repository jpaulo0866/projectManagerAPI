package com.viaflow.manager.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.comment.Comment;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.model.ChangeStatus;
import com.viaflow.manager.api.model.ChangeTeam;
import com.viaflow.manager.api.model.ChangeUser;
import com.viaflow.manager.api.model.MoveProjectStage;
import com.viaflow.manager.api.model.ProjectFilter;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.CommentService;
import com.viaflow.manager.api.service.ProjectService;
import com.viaflow.manager.api.session.SessionUtils;
import com.viaflow.manager.api.validation.BaseValidation;
import com.viaflow.manager.api.validation.ProjectValidation;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*")
public class ProjectWebController extends BaseController<Project, ProjectService, BaseValidation<Project>> {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private BaseValidation<Project> baseValidation;

	@Autowired
	private CommentService commentService;

	@Autowired
	private BaseValidation<Comment> commentValidation;

	@Autowired
	private SessionUtils sessionUtils;

	@Override
	protected ProjectService getService() {
		return this.projectService;
	}

	@Override
	protected BaseValidation<Project> getValidation() {
		return this.baseValidation;
	}
	
	@Override
	@PostMapping
	public ResponseEntity<Response<Project>> create(HttpServletRequest req, @RequestBody Project project, 
			BindingResult result) { 
		Response<Project> response = new Response<>();
		try {
			BaseValidation<Project> validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(project, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			User userOn = sessionUtils.userFromRequest(req);
			project.setProjectUser(userOn);
			Project persistedObject = getService().createOrUpdate(project);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}		
		
		return ResponseEntity.ok(response);
	}
	
	// CREATE
	@PostMapping("/comment")
	public ResponseEntity<Response<Comment>> createComment(HttpServletRequest req, @RequestBody Comment object, 
			BindingResult result) { 
		Response<Comment> response = new Response<>();
		try {
			if (commentValidation != null) {
				if (!commentValidation.validateObject(object, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			Comment persistedObject = commentService.createOrUpdate(object);
			response.setData(persistedObject);

		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping("/comment/{id}")
	public ResponseEntity<Response<Comment>> findCommentByID(@PathVariable("id") String id) {
		Response<Comment> response = new Response<>();
		Comment obj = commentService.findById(id);
		if (obj == null) {
			response.getErrors().add("Register not found " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(obj);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/comment/{id}/{page}/{count}")
	public ResponseEntity<Response<Page<Comment>>> findAllComment(@PathVariable("id") String projectId,
			@PathVariable("page") int page, @PathVariable("count") int count) { 
		Response<Page<Comment>> response = new Response<>();
		Page<Comment> list = commentService.findAllByProjectId(projectId, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/move")
	public ResponseEntity<Response<Project>> moveProject(HttpServletRequest req,
			@RequestBody MoveProjectStage moveProjectStage, BindingResult result) {
		Response<Project> response = new Response<>();
		try {
			User userOn = this.sessionUtils.userFromRequest(req);
			response.setData(getService().move(moveProjectStage, userOn));
		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	@PutMapping("/changeuser")
	public ResponseEntity<Response<Project>> changeUserProject(HttpServletRequest req,
			@RequestBody ChangeUser changeUser, BindingResult result) {
		Response<Project> response = new Response<>();

		try {
			User userOn = this.sessionUtils.userFromRequest(req);
			response.setData(getService().changeUser(changeUser, userOn));
		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("/changeteam")
	public ResponseEntity<Response<Project>> changeTeamProject(HttpServletRequest req,
			@RequestBody ChangeTeam changeTeam, BindingResult result) {
		Response<Project> response = new Response<>();

		try {
			User userOn = this.sessionUtils.userFromRequest(req);
			response.setData(getService().changeTeam(changeTeam, userOn));

		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/changestatus")
	public ResponseEntity<Response<Project>> changeTeamProject(HttpServletRequest req,
			@RequestBody ChangeStatus changeStatus, BindingResult result) {
		Response<Project> response = new Response<>();

		try {
			User userOn = this.sessionUtils.userFromRequest(req);
			response.setData(getService().changeStatus(changeStatus, userOn));
		} catch (Exception e) {
			response.getErrors().add("Critical Error! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/find/complex/{title}/{description}/{userId}/{date}/{contractId}/{projectTypeId}/"
			+ "{statusId}/{projectStageId}/{projectPriorityId}/{ownerUserId}/{ownerTeamId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByMultiParams(
			@PathVariable("title") String title,
			@PathVariable("description") String description, 
			@PathVariable("userId") String userId,
			@PathVariable("date") String date, 
			@PathVariable("contractId") String contractId,
			@PathVariable("projectTypeId") String projectTypeId, 
			@PathVariable("statusId") String statusId,
			@PathVariable("projectStageId") String projectStageId,
			@PathVariable("projectPriorityId") String projectPriorityId,
			@PathVariable("ownerUserId") String ownerUserId, 
			@PathVariable("ownerTeamId") String ownerTeamId,
			@PathVariable("page") int page, 
			@PathVariable("count") int count) throws ParseException {
			Response<Page<Project>> response = new Response<>();
			ProjectFilter projectFilter = new ProjectFilter();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
			projectFilter.setTitle(title.equals("undefined") ? "" : title);
			projectFilter.setDescription(description.equals("undefined") ? "" : description);
			projectFilter.setUserId(userId.equals("undefined") ? "" : userId); 
			Date dater = date.equals("undefined") ? null :  format.parse(date);
			projectFilter.setDate(dater);
			projectFilter.setContractId(contractId.equals("undefined") ? "" : contractId);
			projectFilter.setProjectTypeId(projectTypeId.equals("undefined") ? "" : projectTypeId);
			projectFilter.setStatusId(statusId.equals("undefined") ? "" : statusId);
			projectFilter.setProjectStageId(projectStageId.equals("undefined") ? "" : projectStageId);
			projectFilter.setProjectPriorityId(projectPriorityId.equals("undefined") ? "" : projectPriorityId);
			projectFilter.setOwnerUserId(ownerUserId.equals("undefined") ? "" : ownerUserId);
			projectFilter.setOwnerTeamId(ownerTeamId.equals("undefined") ? "" : ownerTeamId);
			
		
		if( !((ProjectValidation) getValidation()).validateFilter(projectFilter)) 
		{
			response.getErrors().add("Selecione ao menos um dos par�metros de pesquisa!!!!!!!!!!!!!!! ");
			return ResponseEntity.badRequest().body(response);
		}

		Page<Project> list = getService().findByMultiParams(title, description, userId, dater, contractId, projectTypeId, statusId, projectStageId, projectPriorityId, ownerUserId, ownerTeamId, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/title/{title}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByName(@PathVariable("title") String title, @PathVariable("page") int page, @PathVariable("count") int count) {
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findByTitle(title, page, count);
		
		if (project == null) {
			response.getErrors().add("Register not found " + title);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(project);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/find/user/{idUser}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByUser(@PathVariable("idUser") String userId, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findByUser(userId, page, count);
		
		if (project == null) {
			response.getErrors().add("Register not found " + userId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(project);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/contract/{contractId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByContractId(@PathVariable("contractId") String contractId, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findByContractId(contractId, page, count);
		
		if(project == null) {
			response.getErrors().add("ID not found" + contractId);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(project);
		return ResponseEntity.ok(response);
	}

		
	@GetMapping("/find/stage/{stageId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByProjectStage(@PathVariable("stageId") String projectStageId, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = this.getService().findByProjectStage(projectStageId, page, count);
		
		if (project == null) {
			response.getErrors().add("Register not found " + projectStageId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(project);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/status/{statusId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectByStatus(@PathVariable("statusId") String statusId, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = this.getService().findByProjectStatus(statusId, page, count);
		
		if (project == null) {
			response.getErrors().add("Register not found " + statusId);
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/find/owner/user/{userId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectOwnerUser(@PathVariable("userId") String ownerUser,
			@PathVariable("page") int page, @PathVariable("count") int count) {
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findProjectsByOwnerUser(ownerUser, page, count);
		response.setData(project);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/find/owner/team/{teamId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectOwnerTeam(@PathVariable("teamId") String ownerTeam,
			@PathVariable("page") int page, @PathVariable("count") int count) {
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findProjectsByOwnerTeam(ownerTeam, page, count);
		response.setData(project);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/find/priority/{projectPriorityId}/{page}/{count}")
	public ResponseEntity<Response<Page<Project>>> getProjectPriority(
			@PathVariable("projectPriorityId") String projectPriority, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		Response<Page<Project>> response = new Response<>();
		Page<Project> project = getService().findProjectsByProjectPriority(projectPriority, page, count);
		response.setData(project);
		return ResponseEntity.ok(response);
	}
}
