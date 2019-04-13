package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.Menu;

@Service
public interface MenuService extends BaseService<Menu> {
	Menu findByMenuNameIgnoreCase(String menuName);
}
