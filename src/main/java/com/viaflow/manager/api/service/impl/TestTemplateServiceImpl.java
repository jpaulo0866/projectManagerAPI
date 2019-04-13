package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestTemplate;
import com.viaflow.manager.api.repository.TestTemplateRepository;
import com.viaflow.manager.api.service.TestTemplateService;

@Service
public class TestTemplateServiceImpl extends BaseServiceImpl<TestTemplate, TestTemplateRepository> implements TestTemplateService{

	@Autowired
	private TestTemplateRepository testTemplateRepository;
	
	@Override
	protected TestTemplateRepository getRepo() {
		return this.testTemplateRepository;
	}
	
	@Override
	public Page<TestTemplate> findByTestTemplateNameIgnoreCaseContaining(String testTemplateName, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByTestTemplateNameIgnoreCaseContaining(testTemplateName, pages);
	}

	

}
