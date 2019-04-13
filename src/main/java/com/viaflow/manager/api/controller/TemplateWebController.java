package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.model.Template;
import com.viaflow.manager.api.service.TemplateService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping(value="/api/template")
@CrossOrigin("*")
public class TemplateWebController extends BaseController<Template, TemplateService, BaseValidation<Template>>{

	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private BaseValidation<Template> baseValidation;
	
	@Override
	protected TemplateService getService() {
		return this.templateService;
	}

	@Override
	protected BaseValidation<Template> getValidation() {
		return this.baseValidation;
	}

}
