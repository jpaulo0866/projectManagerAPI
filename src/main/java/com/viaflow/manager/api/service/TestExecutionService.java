package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestExecution;

@Service
public interface TestExecutionService {
	
	TestExecution createOrUpdate(TestExecution object);
	
	TestExecution findById(String id);
	
	Page<TestExecution> findAll(int page, int count);

}
