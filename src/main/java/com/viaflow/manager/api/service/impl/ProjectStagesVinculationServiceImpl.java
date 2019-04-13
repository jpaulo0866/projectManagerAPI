package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.project.ProjectType;
import com.viaflow.manager.api.entity.stage.ProjectStagesVinculation;
import com.viaflow.manager.api.repository.ProjectStagesVinculationRepository;
import com.viaflow.manager.api.service.ProjectStagesVinculationService;
import com.viaflow.manager.api.service.ProjectTypeService;

@Service
public class ProjectStagesVinculationServiceImpl extends BaseServiceImpl<ProjectStagesVinculation, ProjectStagesVinculationRepository> implements ProjectStagesVinculationService {

	@Autowired
	private ProjectStagesVinculationRepository projectStagesVinculationRepository;
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	@Override
	protected ProjectStagesVinculationRepository getRepo() {
		return this.projectStagesVinculationRepository;
	}

	@Override
	public ProjectStagesVinculation findByProjectTypeProjectTypeName(String projectTypeName) throws Exception {
		Pageable pageable = PageRequest.of(0, 1);
		ProjectType projectType = projectTypeService.findByProjectTypeNameIgnoreCase(projectTypeName);
		if (projectType != null) {
			Page<ProjectStagesVinculation> result = this.projectStagesVinculationRepository.findByProjectTypeProjectTypeId(projectType.getProjectTypeId(), pageable);
			if (result.getContent().size() == 0) {
				throw new Exception(String.format("Nenhum Vinculo de Est�gio de Projeto encontrado para o tipo de Projeto %s", projectTypeName));
			}
			
			return result.getContent().get(0);
		} else {
			throw new Exception(String.format("Tipo de Projeto %s n�o encontrado", projectTypeName));
		}		
	}


}
