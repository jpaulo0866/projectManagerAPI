package com.viaflow.manager.api.entity.component;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class Menu extends DTOBase {

	@Id
	private String menuId;

	@NotEmpty
	@Indexed(unique=true)
	@TextIndexed
	private String menuName;

	@NotEmpty
	private boolean disabled;

	@DBRef(lazy = true)
	private List<SubMenu> subMenu;

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<SubMenu> getSubMenus() {
		return subMenu;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenu = subMenus;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", inativo=" + disabled + ", subMenus=" + subMenu
				+ "]";
	}

}
