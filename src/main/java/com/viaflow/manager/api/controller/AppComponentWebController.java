package com.viaflow.manager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viaflow.manager.api.entity.component.AppComponent;
import com.viaflow.manager.api.service.AppComponentService;
import com.viaflow.manager.api.validation.BaseValidation;

@RestController
@RequestMapping("/api/component")
@CrossOrigin(origins = "*")
public class AppComponentWebController extends BaseController<AppComponent, AppComponentService, BaseValidation<AppComponent>> {

	@Autowired
	private AppComponentService componentService;

	@Autowired
	private BaseValidation<AppComponent> baseValidation;

	@Override
	protected AppComponentService getService() {
		return this.componentService;
	}

	@Override
	protected BaseValidation<AppComponent> getValidation() {
		return this.baseValidation;
	}
}
