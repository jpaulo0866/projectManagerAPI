package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.DocumentExecution;

@Service
public interface DocumentExecutionService {

	DocumentExecution createOrUpdate(DocumentExecution object);
	
	DocumentExecution findById(String id);
	
	Page<DocumentExecution> findAll(int page, int count);
	
	Page<DocumentExecution> findByTestPlan(String testPlanId, int page, int count);
}
