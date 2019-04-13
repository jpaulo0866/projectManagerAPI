package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.Status;
import com.viaflow.manager.api.repository.StatusRepository;
import com.viaflow.manager.api.service.StatusService;

@Service
public class StatusServiceImpl extends BaseServiceImpl<Status, StatusRepository> implements StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	protected StatusRepository getRepo() {
		return this.statusRepository;
	}
}


