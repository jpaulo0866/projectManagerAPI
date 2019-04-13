package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.documentation.TestDescription;

@Repository
public interface TestDescriptionRepository extends MongoRepository<TestDescription, String> {

}
