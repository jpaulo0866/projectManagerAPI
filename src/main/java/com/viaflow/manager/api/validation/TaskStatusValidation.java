package com.viaflow.manager.api.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.viaflow.manager.api.entity.project.tasks.TaskStatusChanged;

@Component
public class TaskStatusValidation implements BaseValidation<TaskStatusChanged> {

	@Override
	public boolean validateObject(TaskStatusChanged object, BindingResult result) {
		if (object.getNewStatusTask() == null) {
			result.addError(new ObjectError("TaskStatusChanged", " New Status Tesk should be informed"));
		}
		if (object.getOldStatusTask() == null) {
			result.addError(new ObjectError("TaskStatusChanged", " Old Status should be informed"));

		}
		return !result.hasErrors();
	}

}
