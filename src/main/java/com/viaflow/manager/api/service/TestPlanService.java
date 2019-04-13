package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.documentation.TestPlan;

@Service
public interface TestPlanService extends BaseService<TestPlan> {
	TestPlan createOrUpdate(TestPlan testPlanUpdate);
	TestPlan findByTestPlanId(String testPlanId);
	Page<TestPlan> findAllByTestPlanId(int page, int count);
}
