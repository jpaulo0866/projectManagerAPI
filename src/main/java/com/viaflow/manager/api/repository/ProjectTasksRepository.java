package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.viaflow.manager.api.entity.project.tasks.Task;

public interface ProjectTasksRepository extends MongoRepository<Task, String> {

}

