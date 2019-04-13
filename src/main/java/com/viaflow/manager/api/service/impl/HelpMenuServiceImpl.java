package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.help.HelpMenu;
import com.viaflow.manager.api.repository.HelpMenuRepository;
import com.viaflow.manager.api.service.HelpMenuService;

@Service
public class HelpMenuServiceImpl extends BaseServiceImpl<HelpMenu, HelpMenuRepository> implements HelpMenuService {

	@Autowired
	private HelpMenuRepository helpMenuRepository;
	
	@Override
	protected HelpMenuRepository getRepo() {
		return this.helpMenuRepository;
	}

	@Override
	public HelpMenu findByComponentComponentId(String componentId) {
		return this.helpMenuRepository.findByComponentComponentId(componentId);
	}

}
