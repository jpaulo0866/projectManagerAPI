package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.model.Template;

@Repository
public interface TemplateRepository extends MongoRepository<Template, String>{

}
