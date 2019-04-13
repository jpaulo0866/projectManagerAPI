package com.viaflow.manager.api.repository;

import com.viaflow.manager.api.entity.bug.Bug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends MongoRepository<Bug, String> {

}
