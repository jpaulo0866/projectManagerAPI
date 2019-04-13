package com.viaflow.manager.api.entity.permission;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.component.AppComponent;
import com.viaflow.manager.api.entity.component.ComponentItem;
import com.viaflow.manager.api.entity.component.Menu;
import com.viaflow.manager.api.entity.component.SubMenu;
import com.viaflow.manager.api.entity.user.Profile;
import com.viaflow.manager.api.model.EntryType;

@Document
public class Permission extends DTOBase {

	@Id
	private String permissionId;

	@NotEmpty
	private String permissionName;

	@DBRef
	private Profile profile;

	private List<EntryType<Menu, TypePermission>> menus;

	private List<EntryType<SubMenu, TypePermission>> subMenus;

	private List<EntryType<ComponentItem, TypePermission>> itemComponents;

	private List<EntryType<AppComponent, TypePermission>> components;

	public List<EntryType<Menu, TypePermission>> getMenus() {
		return menus;
	}

	public void setMenus(List<EntryType<Menu, TypePermission>> menus) {
		this.menus = menus;
	}

	public List<EntryType<SubMenu, TypePermission>> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<EntryType<SubMenu, TypePermission>> subMenus) {
		this.subMenus = subMenus;
	}

	public List<EntryType<ComponentItem, TypePermission>> getItemComponents() {
		return itemComponents;
	}

	public void setItemComponents(List<EntryType<ComponentItem, TypePermission>> itemComponents) {
		this.itemComponents = itemComponents;
	}

	public List<EntryType<AppComponent, TypePermission>> getComponents() {
		return components;
	}

	public void setComponents(List<EntryType<AppComponent, TypePermission>> components) {
		this.components = components;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
