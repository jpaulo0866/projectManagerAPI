package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.ProjectType;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProjectTypeService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/projecttype")
@CrossOrigin("*")
public class ProjectTypeWebController extends BaseController<ProjectType, ProjectTypeService, BaseValidation<ProjectType>>{

	@Autowired
	private ProjectTypeService demandTypeService;
	
	@Autowired
	private BaseValidation<ProjectType> baseValidation;
	
	@Override
	protected ProjectTypeService getService() {
		return this.demandTypeService;
	}

	@Override
	protected BaseValidation<ProjectType> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{name}")
	public ResponseEntity<Response<ProjectType>> get(@PathVariable("name") String name){
		Response<ProjectType> response = new Response<>();
		ProjectType projectType = getService().findByProjectTypeNameIgnoreCase(name);
		if(projectType == null) {
			response.getErrors().add("Register not found "+ name);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(projectType);
		return ResponseEntity.ok(response);
	}

}
