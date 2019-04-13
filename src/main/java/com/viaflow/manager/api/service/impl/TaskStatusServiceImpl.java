package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.tasks.TaskStatusChanged;
import com.viaflow.manager.api.repository.TaskStatusRepository;
import com.viaflow.manager.api.service.TaskStatusService;

@Service
public class TaskStatusServiceImpl extends BaseServiceImpl<TaskStatusChanged, TaskStatusRepository> implements TaskStatusService {

	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Override
	protected TaskStatusRepository getRepo() {
		return this.taskStatusRepository;
	}
}
