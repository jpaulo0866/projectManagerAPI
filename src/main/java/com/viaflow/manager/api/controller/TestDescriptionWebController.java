package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.documentation.TestDescription;
import com.viaflow.manager.api.service.TestDescriptionService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/testdescription")
@CrossOrigin("*")
public class TestDescriptionWebController extends BaseController<TestDescription, TestDescriptionService, BaseValidation<TestDescription>>  {

	
	@Autowired
	private TestDescriptionService testDescriptionService;
	
	@Autowired
	private BaseValidation<TestDescription> testDescriptionValidation;
	
	@Override
	protected TestDescriptionService getService() {
		return this.testDescriptionService;
	}

	@Override
	protected BaseValidation<TestDescription> getValidation() {
		return this.testDescriptionValidation;
	}

}
