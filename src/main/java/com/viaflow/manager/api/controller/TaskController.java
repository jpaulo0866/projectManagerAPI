package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.tasks.Task;
import com.viaflow.manager.api.service.TaskService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "*")
public class TaskController extends BaseController<Task, TaskService, BaseValidation<Task>> {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private BaseValidation<Task> BaseValidation;
			
	@Override
	protected TaskService getService() {
		return this.taskService;
	}

	@Override
	protected BaseValidation<Task> getValidation() {
		return this.BaseValidation;
	}

}
