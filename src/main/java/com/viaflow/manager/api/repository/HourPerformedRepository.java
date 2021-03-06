package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.appropriation.HourPerformed;

@Repository
public interface HourPerformedRepository extends MongoRepository<HourPerformed, String> {
}
