package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.project.ChangeProjectStatus;

@Service
public interface ChangeProjectStatusService extends BaseService<ChangeProjectStatus>{
	Page<ChangeProjectStatus> findByProjectProjectId(String projectId);
}
