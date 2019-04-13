package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectUser;
import com.viaflow.manager.api.repository.ChangeProjectUserRepository;
import com.viaflow.manager.api.service.ChangeProjectUserService;

@Service
public class ChangeProjectUserServiceImpl extends BaseServiceImpl<ChangeProjectUser, ChangeProjectUserRepository> implements ChangeProjectUserService{

	@Autowired
	private ChangeProjectUserRepository changeProjectUser;

	@Override
	protected ChangeProjectUserRepository getRepo() {
		return this.changeProjectUser;
	}


	@Override
	public Page<ChangeProjectUser> findByProjectProjectId(String projectId) {
		Pageable pages = PageRequest.of(0, 100);
		return this.getRepo().findByProjectProjectId(projectId, pages);
	}

}
