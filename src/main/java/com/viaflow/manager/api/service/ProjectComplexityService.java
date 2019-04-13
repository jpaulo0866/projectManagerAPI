package com.viaflow.manager.api.service;
  
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectComplexity;

@Service
public interface ProjectComplexityService extends BaseService<ProjectComplexity> {
	ProjectComplexity findByProjectComplexityName(String projectComplexityName);
}
