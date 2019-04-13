package com.viaflow.manager.api.controller;

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

import com.viaflow.manager.api.entity.documentation.TestExecution;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TestExecutionService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/tests/testexecution")
@CrossOrigin(origins = "*")
public class TestExecutionWebController {
	
	@Autowired
	private TestExecutionService testExecutionService;
	
	@Autowired
	private BaseValidation<TestExecution> baseValidation;
	
	
	protected TestExecutionService getService() {
		return this.testExecutionService;
	}
	
	protected BaseValidation<TestExecution> getValidation() {
		return this.baseValidation;
	}

	@PostMapping
	public ResponseEntity<Response<TestExecution>> create(HttpServletRequest req, @RequestBody TestExecution testExecution, 
			BindingResult result) { 
		Response<TestExecution> response = new Response<>();
	
		try {
			BaseValidation<TestExecution> validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(testExecution, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					
					return ResponseEntity.badRequest().body(response);
				}
			}
			TestExecution persistedObject = getService().createOrUpdate(testExecution);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Test Execution Error posttt" + e.toString());
			return ResponseEntity.badRequest().body(response);
		}		
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<TestExecution>> update(HttpServletRequest req, @RequestBody TestExecution testExecution, 
			BindingResult result) { 
		Response<TestExecution> response = new Response<>();
		
		try {
			BaseValidation<TestExecution> validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(testExecution, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			TestExecution persistedObject = getService().createOrUpdate(testExecution);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Test Execution Error put" + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Response<TestExecution>> findById(@PathVariable("id") String id) { 
		Response<TestExecution> response = new Response<>();
		TestExecution testExecution = getService().findById(id);
		if (testExecution == null) {
			response.getErrors().add("Register not found " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(testExecution);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{page}/{count}")
	public ResponseEntity<Response<Page<TestExecution>>> findAll(@PathVariable("page") int page,
			@PathVariable("count") int count) { 
		Response<Page<TestExecution>> response = new Response<>();
		Page<TestExecution> list = getService().findAll(page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
}
