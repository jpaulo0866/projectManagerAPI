package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProjectStageService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/projectstage")
@CrossOrigin(origins = "*")
public class ProjectStageWebController extends BaseController<ProjectStage, ProjectStageService, BaseValidation<ProjectStage>> {

	@Autowired
	private ProjectStageService projectStageService;
	
	@Autowired
	private BaseValidation<ProjectStage> baseValidation;

	@Override
	protected ProjectStageService getService() {
		return this.projectStageService;
	}

	@Override
	protected BaseValidation<ProjectStage> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{projectStageName}")
	public ResponseEntity<Response<Page<ProjectStage>>> getProjectStagebyName(
			@PathVariable("projectStageName") String projectStageName) { 
		Response<Page<ProjectStage>> response = new Response<>();
		Page<ProjectStage> list = getService().findProjectStageByProjectStageNameIgnoreCaseContaining(projectStageName, 0, 100);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
}
