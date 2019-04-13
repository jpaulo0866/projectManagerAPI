package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.bug.Bug;
import com.viaflow.manager.api.repository.BugRepository;
import com.viaflow.manager.api.service.BugService;

@Service
public class BugServiceImpl extends BaseServiceImpl<Bug, BugRepository> implements BugService {

	@Autowired
	private BugRepository bugRepository;
	
	@Override
	protected BugRepository getRepo() {
		return this.bugRepository;
	}

}
