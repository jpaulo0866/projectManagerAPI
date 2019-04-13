package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectType;

@Service
public interface ProjectTypeService extends BaseService<ProjectType>{
	ProjectType findByProjectTypeNameIgnoreCase(String projectTypeName);

}
