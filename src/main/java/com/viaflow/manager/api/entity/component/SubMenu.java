package com.viaflow.manager.api.entity.component;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class SubMenu extends DTOBase {

	@Id
	private String subMenuId;

	@NotEmpty
	@Indexed(unique=true)
	private String subMenuName;

	private boolean disabled;

	@DBRef
	private List<AppComponent> components;

	public String getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(String subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<AppComponent> getComponents() {
		return components;
	}

	public void setComponents(List<AppComponent> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Submenu [submenuId=" + subMenuId + ", nome=" + subMenuName + ", inativo=" + disabled + ", componente="
				+ components + "]";
	}

}
