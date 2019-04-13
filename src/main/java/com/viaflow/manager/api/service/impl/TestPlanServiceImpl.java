package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestPlan;
import com.viaflow.manager.api.repository.TestPlanRepository;
import com.viaflow.manager.api.service.TestPlanService;

@Service
public class TestPlanServiceImpl extends BaseServiceImpl<TestPlan, TestPlanRepository>  implements TestPlanService {

	@Autowired
	private TestPlanService testPlanService;
	
	@Autowired
	private TestPlanRepository testPlanRepository;
	
	@Override
	protected TestPlanRepository getRepo() {
		return this.testPlanRepository;
	}

	public Page<TestPlan> findAllByTestPlanId(int page, int count) {
		return this.testPlanService.findAllByTestPlanId(page, count);
	}

	public Page<TestPlan> findAllByTestPlanId(String testPlanId, Pageable pages){
		return this.testPlanRepository.findAllByTestPlanId(testPlanId, pages);
	}

	@Override
	public TestPlan findByTestPlanId(String testPlanId) {
		return this.testPlanRepository.findByTestPlanId(testPlanId);
	}

	


}
