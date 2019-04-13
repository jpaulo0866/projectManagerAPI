package com.viaflow.manager.api.validation;

import org.springframework.validation.BindingResult;

import com.viaflow.manager.api.model.MoveProjectStage;

public class MoveProjectStageValidation implements BaseValidation<MoveProjectStage>{

	@Override
	public boolean validateObject(MoveProjectStage object, BindingResult result) {
		return true;
	}

}
