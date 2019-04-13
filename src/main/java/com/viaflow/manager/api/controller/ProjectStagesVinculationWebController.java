package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.viaflow.manager.api.entity.stage.ProjectStagesVinculation;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.ProjectStagesVinculationService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/projectstagevinculation")
@CrossOrigin(origins = "*")
public class ProjectStagesVinculationWebController extends BaseController<ProjectStagesVinculation, ProjectStagesVinculationService, BaseValidation<ProjectStagesVinculation>>{

	@Autowired
	private ProjectStagesVinculationService projectStagesVinculationService;
	
	@Autowired
	private BaseValidation<ProjectStagesVinculation> baseValidation;
	
	@Override
	protected ProjectStagesVinculationService getService() {
		return this.projectStagesVinculationService;
	}

	@Override
	protected BaseValidation<ProjectStagesVinculation> getValidation() {
		return this.baseValidation;
	}

	@GetMapping("/find/projecttype/{name}")
	public ResponseEntity<Response<ProjectStagesVinculation>> findAllByProjectTypeProjectTypeName(@PathVariable("name") String projectTypeName) { 
		Response<ProjectStagesVinculation> response = new Response<>();
		try {
			response.setData(projectStagesVinculationService.findByProjectTypeProjectTypeName(projectTypeName));
		} catch (Exception e) {
			response.getErrors().add("Critical Error on Request! " + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

}
