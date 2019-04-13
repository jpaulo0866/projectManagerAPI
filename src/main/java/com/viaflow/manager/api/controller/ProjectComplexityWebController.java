package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.ProjectComplexity;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProjectComplexityService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/projectcomplexity")
@CrossOrigin("*")
public class ProjectComplexityWebController extends BaseController<ProjectComplexity, ProjectComplexityService, BaseValidation<ProjectComplexity>> {

	@Autowired
	private ProjectComplexityService projectPriorityService;
	
	@Autowired
	private BaseValidation<ProjectComplexity> baseValidation;
	
	@Override
	protected ProjectComplexityService getService() {
		return this.projectPriorityService;
	}

	@Override
	protected BaseValidation<ProjectComplexity> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{projectComplexityName}")
	public ResponseEntity<Response<ProjectComplexity>> getProjectComplexityByName(@PathVariable("projectComplexityName") String name){
		Response<ProjectComplexity> response = new Response<>();
		ProjectComplexity projectComplexity = getService().findByProjectComplexityName(name);
		if (projectComplexity == null) {
			response.getErrors().add("Register not found " + name);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(projectComplexity);
		return ResponseEntity.ok(response);
	}

}



