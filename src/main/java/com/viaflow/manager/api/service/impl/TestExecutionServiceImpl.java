package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestExecution;
import com.viaflow.manager.api.repository.TestExecutionRepository;
import com.viaflow.manager.api.service.TestExecutionService;

@Service
public class TestExecutionServiceImpl implements TestExecutionService{

	@Autowired
	private TestExecutionRepository testExecutionRepository;
	
	protected TestExecutionRepository getRepo() {
		return this.testExecutionRepository;
	}
	
	public TestExecution createOrUpdate(TestExecution testExecution) {
		return this.getRepo().save(testExecution);
	}

	public TestExecution findById(String id) {
		return this.getRepo().findById(id).get();
	}

	public Page<TestExecution> findAll(int page, int count) {
		Pageable pageable = PageRequest.of(page, count);
		return this.getRepo().findAll(pageable);
	}

}
