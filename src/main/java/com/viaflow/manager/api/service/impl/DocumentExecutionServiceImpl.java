package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.DocumentExecution;
import com.viaflow.manager.api.repository.DocumentExecutionRepository;
import com.viaflow.manager.api.service.DocumentExecutionService;

@Service
public class DocumentExecutionServiceImpl implements DocumentExecutionService{
	
	@Autowired
	private DocumentExecutionRepository documentExecutionRepository;
	
	protected DocumentExecutionRepository getRepo() {
		return this.documentExecutionRepository;
	}
	
	@Override
	public DocumentExecution createOrUpdate(DocumentExecution documentExecution) {
		return this.getRepo().save(documentExecution);
	}

	@Override
	public DocumentExecution findById(String id) {
		return this.getRepo().findById(id).get();
	}

	@Override
	public Page<DocumentExecution> findAll(int page, int count) {
		Pageable pageable = PageRequest.of(page, count);
		return this.getRepo().findAll(pageable);
	}

	@Override
	public Page<DocumentExecution> findByTestPlan(String testPlanId, int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.getRepo().findByDocumentExecutionTestPlanTestPlanId(testPlanId, pages);
	}
	
	
}
