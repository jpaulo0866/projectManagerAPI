package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.viaflow.manager.api.entity.documentation.TestPlan;

@Repository
public interface TestPlanRepository extends MongoRepository<TestPlan, String> {
	TestPlan findByTestPlanId(String testPlanId);
	Page<TestPlan> findAllByTestPlanId(String testPlanId, Pageable pages);
}
