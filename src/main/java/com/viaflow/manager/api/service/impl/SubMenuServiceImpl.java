package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.SubMenu;
import com.viaflow.manager.api.repository.SubMenuRepository;
import com.viaflow.manager.api.service.SubMenuService;

@Service
public class SubMenuServiceImpl extends BaseServiceImpl<SubMenu, SubMenuRepository> implements SubMenuService {

	@Autowired
	private SubMenuRepository subMenuRepository;

	@Override
	protected SubMenuRepository getRepo() {
		return this.subMenuRepository;
	}

	@Override
	public SubMenu findBySubMenuNameIgnoreCase(String subMenuName) {
		return this.subMenuRepository.findBySubMenuNameIgnoreCase(subMenuName);
	}

}
