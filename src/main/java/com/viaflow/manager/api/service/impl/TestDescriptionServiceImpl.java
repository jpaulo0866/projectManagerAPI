package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestDescription;
import com.viaflow.manager.api.repository.TestDescriptionRepository;
import com.viaflow.manager.api.service.TestDescriptionService;

@Service
public class TestDescriptionServiceImpl extends BaseServiceImpl<TestDescription, TestDescriptionRepository> implements TestDescriptionService {

	@Autowired
	private TestDescriptionRepository  testDescriptionRepository;

	@Override
	protected TestDescriptionRepository getRepo() {
		return this.testDescriptionRepository;
	}

}
