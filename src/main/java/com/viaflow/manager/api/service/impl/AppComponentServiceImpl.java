package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.AppComponent;
import com.viaflow.manager.api.repository.AppComponentRepository;
import com.viaflow.manager.api.service.AppComponentService;

@Service
public class AppComponentServiceImpl extends BaseServiceImpl<AppComponent, AppComponentRepository> implements AppComponentService {

	@Autowired
	private AppComponentRepository componentItem;

	@Override
	protected AppComponentRepository getRepo() {
		return this.componentItem;
	}

}
