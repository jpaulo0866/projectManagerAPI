package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.documentation.DocumentExecution;

@Repository
public interface DocumentExecutionRepository extends MongoRepository<DocumentExecution, String>{
	Page<DocumentExecution> findByDocumentExecutionTestPlanTestPlanId(String testPlanId, Pageable pages);
}
