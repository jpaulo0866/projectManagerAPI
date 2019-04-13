package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.stage.ProjectStage;

@Service
public interface ProjectStageService extends BaseService<ProjectStage>{
	Page<ProjectStage> findProjectStageByProjectStageNameIgnoreCaseContaining(String projectStageName, int page, int count);

}
