package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.documentation.DocumentExecution;
import com.viaflow.manager.api.entity.documentation.TestPlan;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.DocumentExecutionService;
import com.viaflow.manager.api.service.TestPlanService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/tests")
@CrossOrigin("*")
public class TestPlanWebController extends BaseController<TestPlan, TestPlanService, BaseValidation<TestPlan>> {

	@Autowired
	private TestPlanService testPlanService;
	
	@Autowired
	private DocumentExecutionService documentExecutionService;
	
	@Autowired
	private BaseValidation<TestPlan> testPlanValidation;
	
	@Override
	protected TestPlanService getService() {
		return this.testPlanService;
	}

	@Override
	protected BaseValidation<TestPlan> getValidation() {
		return this.testPlanValidation;
	}
	
	
	
	@Override
	@DeleteMapping(value="{id}")
	public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) { 
		Response<String> response = new Response<>();
		
		Page<DocumentExecution> page = documentExecutionService.findByTestPlan(id, 0, 1);
		
	
		if(page.isEmpty()) {
			try {
				this.getService().delete(id);
				response.setData("Object Deleted");
			} catch (Exception e) {
				response.getErrors().add("Register not found " + id);
				return ResponseEntity.badRequest().body(response);
			}
		}else {
			response.setData("Unable to delete, Test is already running");
		}
		return ResponseEntity.ok(response);
	}
	
	

	
	
	
	


}
