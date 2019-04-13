package com.viaflow.manager.api.entity.component;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class AppComponent extends DTOBase {

	@Id
	private String componentId;

	@NotEmpty
	@Indexed(unique=true)
	@TextIndexed
	private String componentName;

	@TextIndexed
	private String routerLink;

	@Transient
	private List<ComponentItem> componentItem;

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getRouterLink() {
		return routerLink;
	}

	public void setRouterLink(String routerLink) {
		this.routerLink = routerLink;
	}

	public List<ComponentItem> getComponentItem() {
		return componentItem;
	}

	public void setComponentItem(List<ComponentItem> componentItem) {
		this.componentItem = componentItem;
	}

	@Override
	public String toString() {
		return "Componente [componentId=" + componentId + ", componentName=" + componentName + ", routerLink="
				+ routerLink + ", componentItem=" + componentItem + "]";
	}
}
