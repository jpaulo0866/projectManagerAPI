package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.bug.BugType;
import com.viaflow.manager.api.service.BugTypeService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/bugtype")
@CrossOrigin(origins = "*")
public class BugTypeController extends BaseController<BugType, BugTypeService, BaseValidation<BugType>>{

	@Autowired
	private BugTypeService bugTypeService;
	
	@Autowired
	private BaseValidation<BugType> baseValidation;
	
	@Override
	protected BugTypeService getService() {
		return this.bugTypeService;
	}

	@Override
	protected BaseValidation<BugType> getValidation() {
		return this.baseValidation;
	}

}
