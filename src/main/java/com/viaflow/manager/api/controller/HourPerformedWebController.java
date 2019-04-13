package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.appropriation.HourPerformed;
import com.viaflow.manager.api.service.HourPerformedService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/hourperformed")
@CrossOrigin(origins="*")
public class HourPerformedWebController extends BaseController<HourPerformed, HourPerformedService, BaseValidation<HourPerformed>>{

	@Autowired
	private HourPerformedService hourPerformed;
	
	@Autowired
	private BaseValidation<HourPerformed> baseValidation;
	
	@Override
	protected HourPerformedService getService() {
		return this.hourPerformed;
	}

	@Override
	protected BaseValidation<HourPerformed> getValidation() {
		return this.baseValidation;
	}

}
