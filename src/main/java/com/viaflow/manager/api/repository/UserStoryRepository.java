package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.us.UserStory;

@Repository
public interface UserStoryRepository extends MongoRepository<UserStory,  String> {

}

