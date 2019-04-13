package com.viaflow.manager.api.service;

import org.springframework.stereotype.Service;

import com.viaflow.manager.api.entity.component.SubMenu;

@Service
public interface SubMenuService extends BaseService<SubMenu> {
	SubMenu findBySubMenuNameIgnoreCase(String subMenuName);
}
