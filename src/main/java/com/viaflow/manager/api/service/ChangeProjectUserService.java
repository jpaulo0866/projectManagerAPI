package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ChangeProjectUser;

@Service
public interface ChangeProjectUserService extends BaseService<ChangeProjectUser> {
	Page<ChangeProjectUser> findByProjectProjectId(String projectId); 

}
