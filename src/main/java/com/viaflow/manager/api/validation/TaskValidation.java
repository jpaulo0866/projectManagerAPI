package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.tasks.Task;

@Component
public class TaskValidation implements BaseValidation<Task> {

	@Override
	public boolean validateObject(Task object, BindingResult result) {
		if (object.getProjectTaskTitle() == null) {
			result.addError(new ObjectError("Task", "Task title should be informed"));
		}
		if (object.getProjectTaskDescription() == null) {
			result.addError(new ObjectError("Task", "Task description should be informed"));
		}
		return !result.hasErrors();
	}

}
