package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.bug.BugType;
import com.viaflow.manager.api.repository.BugTypeRepository;
import com.viaflow.manager.api.service.BugTypeService;

@Service
public class BugTypeServiceImpl extends BaseServiceImpl<BugType, BugTypeRepository> implements BugTypeService{

	@Autowired
	private BugTypeRepository bugTypeRepository;
	
	@Override
	protected BugTypeRepository getRepo() {
		return this.bugTypeRepository;
	}

}
