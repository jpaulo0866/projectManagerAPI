package com.viaflow.manager.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viaflow.manager.api.entity.project.tasks.TaskStatusChanged;
@Repository
public interface TaskStatusRepository extends MongoRepository<TaskStatusChanged,   String> {

}
