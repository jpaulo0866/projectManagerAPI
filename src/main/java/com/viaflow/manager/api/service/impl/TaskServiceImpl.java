package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.tasks.Task;
import com.viaflow.manager.api.repository.TaskRepository;
import com.viaflow.manager.api.service.TaskService;

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskRepository>implements TaskService  {

	@Autowired
	private  TaskRepository taskRepositori;
	
	@Override
	protected TaskRepository getRepo() {
		return this.taskRepositori;
	}

}
