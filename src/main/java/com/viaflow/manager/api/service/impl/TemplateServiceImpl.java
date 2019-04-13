package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.model.Template;
import com.viaflow.manager.api.repository.TemplateRepository;
import com.viaflow.manager.api.service.TemplateService;

@Service
public class TemplateServiceImpl extends BaseServiceImpl<Template, TemplateRepository> implements TemplateService{

	@Autowired
	private TemplateRepository templateRepository;
	
	@Override
	protected TemplateRepository getRepo() {
		return this.templateRepository;
	}

}
