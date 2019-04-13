package com.viaflow.manager.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.documentation.TestTemplate;

@Repository
public interface TestTemplateRepository extends MongoRepository<TestTemplate, String>{
	Page<TestTemplate> findByTestTemplateNameIgnoreCaseContaining(String testTemplateName, Pageable pages);

}
