package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.documentation.TestTemplate;
import com.viaflow.manager.api.response.Response;
import com.viaflow.manager.api.service.TestTemplateService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/tests/template")
@CrossOrigin(origins = "*")
public class TestTemplateWebController extends BaseController<TestTemplate, TestTemplateService, BaseValidation<TestTemplate>>{

	@Autowired
	private TestTemplateService testTemplateService;
	
	@Autowired
	private BaseValidation<TestTemplate> baseValidation;
	
	@Override
	protected TestTemplateService getService() {
		return this.testTemplateService;
	}

	@Override
	protected BaseValidation<TestTemplate> getValidation() {
		return this.baseValidation;
	}
	
	@GetMapping(value = "/find/name/{testtemplatename}/{page}/{count}")
	public ResponseEntity<Response<Page<TestTemplate>>> getTemplateName(
			@PathVariable("testtemplatename") String testtemplatename,
			@PathVariable("page") int page,
			@PathVariable("count") int count){
		Response<Page<TestTemplate>> response = new Response<>();
		Page<TestTemplate> list = getService().findByTestTemplateNameIgnoreCaseContaining(testtemplatename, page, count);
		response.setData(list);
		return ResponseEntity.ok(response);
	}

}
