package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.bug.BugType;

@Repository
public interface BugTypeRepository extends MongoRepository<BugType, String> {

}
