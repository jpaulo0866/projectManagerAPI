package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.help.HelpMenu;

@Service
public interface HelpMenuService extends BaseService<HelpMenu>{

	HelpMenu findByComponentComponentId(String componentId);
}
