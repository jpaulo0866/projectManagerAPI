package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.project.ChangeProjectStage;

@Service
public interface ChangeProjectStageService extends BaseService<ChangeProjectStage> {
	Page<ChangeProjectStage> findByProjectProjectId(String projectId);
}
