package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.project.tasks.TaskStatusChanged;
import com.viaflow.manager.api.service.TaskStatusService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/taskstatus")
@CrossOrigin(origins = "*")
public class TaskStatusController extends BaseController<TaskStatusChanged, TaskStatusService, BaseValidation<TaskStatusChanged>> {

	@Autowired
	private TaskStatusService taskStatusService;
	
	@Autowired
	private BaseValidation<TaskStatusChanged> BaseValidation;
	
	@Override
	protected TaskStatusService getService() {
		return this.taskStatusService;
	}

	@Override
	protected BaseValidation<TaskStatusChanged> getValidation() {
		return this.BaseValidation;
	}

}
