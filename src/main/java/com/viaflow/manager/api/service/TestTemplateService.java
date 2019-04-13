package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestTemplate;

@Service
public interface TestTemplateService extends BaseService<TestTemplate>{
	Page<TestTemplate> findByTestTemplateNameIgnoreCaseContaining(String testTemplateName, int page, int count);
}
