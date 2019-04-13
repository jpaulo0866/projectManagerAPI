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

import com.viaflow.manager.api.entity.documentation.DocumentExecution;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.DocumentExecutionService;
import com.viaflow.manager.api.service.TestPlanService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/tests/document")
@CrossOrigin(origins = "*")
public class DocumentExecutionWebController {
	
	@Autowired
	private DocumentExecutionService documentExecutionService;
	
	@Autowired
	private BaseValidation<DocumentExecution> baseValidation;
	
	@Autowired
	private TestPlanService testPlanService;
	
	protected TestPlanService getTestPlanService() {
		return this.testPlanService;
	}
	
	protected DocumentExecutionService getService() {
		return this.documentExecutionService;
	}
	
	protected BaseValidation<DocumentExecution> getValidation() {
		return this.baseValidation;
	}
	
	@PostMapping
	public ResponseEntity<Response<DocumentExecution>> create(HttpServletRequest req, @RequestBody DocumentExecution documentExecution, 
			BindingResult result) { 
		Response<DocumentExecution> response = new Response<>();
		try {
			BaseValidation<DocumentExecution> validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(documentExecution, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			DocumentExecution persistedObject = getService().createOrUpdate(documentExecution);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Document Execution Error posttt" + e.toString());
			return ResponseEntity.badRequest().body(response);
		}		
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<Response<DocumentExecution>> update(HttpServletRequest req, @RequestBody DocumentExecution documentExecution, 
			BindingResult result) { 
		Response<DocumentExecution> response = new Response<>();
		
		try {
			BaseValidation<DocumentExecution> validation = getValidation();
			if (validation != null) {
				if (!validation.validateObject(documentExecution, result)) {
					result.getAllErrors().forEach(error -> {
						response.getErrors().add(error.getDefaultMessage());
					});
					return ResponseEntity.badRequest().body(response);
				}
			}
			DocumentExecution persistedObject = getService().createOrUpdate(documentExecution);
			response.setData(persistedObject);
			
		} catch (Exception e) {
			response.getErrors().add("Document Execution Error put" + e.toString());
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Response<DocumentExecution>> findById(@PathVariable("id") String id) { 
		Response<DocumentExecution> response = new Response<>();
		DocumentExecution documentExecution = getService().findById(id);
		if (documentExecution == null) {
			response.getErrors().add("Register not found " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(documentExecution);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="{page}/{count}")
	public ResponseEntity<Response<Page<DocumentExecution>>> findAll(@PathVariable("page") int page,
			@PathVariable("count") int count) { 
		Response<Page<DocumentExecution>> response = new Response<>();
		Page<DocumentExecution> list = getService().findAll(page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/find/{testplanid}/{page}/{count}")
	public ResponseEntity<Response<Page<DocumentExecution>>> findById(@PathVariable("testplanid") String testPlanId, 
																@PathVariable("page") int page,
																@PathVariable("count") int count) { 
		Response<Page<DocumentExecution>> response = new Response<>();
		Page<DocumentExecution> docExec = documentExecutionService.findByTestPlan(testPlanId, page, count);
		response.setData(docExec);
		return ResponseEntity.ok(response);
	}

}
