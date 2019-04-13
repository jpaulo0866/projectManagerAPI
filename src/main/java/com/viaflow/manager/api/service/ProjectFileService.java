package com.viaflow.manager.api.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectFile;

@Service
public interface ProjectFileService extends BaseService<ProjectFile>{
	
	Page<ProjectFile> findByProjectFile(String projectFile, int page , int count);


}
