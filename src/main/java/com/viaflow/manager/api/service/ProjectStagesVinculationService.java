package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;
import com.viaflow.manager.api.entity.stage.ProjectStagesVinculation;

@Service
public interface ProjectStagesVinculationService extends BaseService<ProjectStagesVinculation>{
	ProjectStagesVinculation findByProjectTypeProjectTypeName(String projectTypeName) throws Exception;
}
