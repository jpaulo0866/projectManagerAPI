package com.viaflow.manager.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.ProjectFile;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProjectFileService;
import com.viaflow.manager.api.validation.BaseValidation;



@RestController
@RequestMapping(value="/api/project/file")
@CrossOrigin("*")
public class ProjectFileWebController extends BaseController<ProjectFile, ProjectFileService, BaseValidation<ProjectFile>>{
	
	@Autowired
	private ProjectFileService projectFileService;
	
	@Autowired
	private BaseValidation<ProjectFile> baseValidation;
	
	@Override
	protected ProjectFileService getService() {
		
		return this.projectFileService;
	}

	@Override
	protected BaseValidation<ProjectFile> getValidation() {
		
		return this.baseValidation;
	}
	
	@GetMapping("{projectId}/{page}/{count}")
	public ResponseEntity<Response<Page<ProjectFile>>> getProjectId(@PathVariable("projectId") String projectId, @PathVariable("page") int page, @PathVariable("count") int count){
		Response<Page<ProjectFile>> response = new Response<>();
		Page<ProjectFile> projectFile = getService().findByProjectFile(projectId, page, count);
		if(projectFile == null) {
			response.getErrors().add("Project not found" + projectId);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(projectFile);
		return ResponseEntity.ok(response);
	}

}
