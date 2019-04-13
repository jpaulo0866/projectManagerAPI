
package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.viaflow.manager.api.entity.project.tasks.Task;
import com.viaflow.manager.api.repository.ProjectTasksRepository;
import com.viaflow.manager.api.service.ProjectTaskService;

public class ProjectTaskServiceImpl extends BaseServiceImpl<Task, ProjectTasksRepository> implements ProjectTaskService  {

	@Autowired
	private ProjectTasksRepository projectTasksRepository;
	
	@Override
	protected ProjectTasksRepository getRepo() {
		return this.projectTasksRepository;
	}

}

