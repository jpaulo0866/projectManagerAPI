package com.viaflow.manager.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.Menu;
import com.viaflow.manager.api.repository.MenuRepository;
import com.viaflow.manager.api.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuRepository> implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	protected MenuRepository getRepo() {
		return this.menuRepository;
	}

	@Override
	public Menu findByMenuNameIgnoreCase(String menuName) {
		return this.menuRepository.findByMenuNameIgnoreCase(menuName);
	}

}
