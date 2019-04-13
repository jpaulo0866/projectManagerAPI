package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.documentation.TestExecution;

@Repository
public interface TestExecutionRepository extends MongoRepository<TestExecution, String>{
}
