package com.viaflow.manager.api.entity.component;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class ComponentItem extends DTOBase{

	@Id
	private String componentItemId;
	
	@NotEmpty
	@TextIndexed
	private String componentItemIdHTML;
	
	@NotEmpty
	@TextIndexed
	private String componentValue;

	@DBRef
	private AppComponent appComponent;

	public String getComponentItemId() {
		return componentItemId;
	}

	public void setComponentItemId(String componentItemId) {
		this.componentItemId = componentItemId;
	}

	public String getComponentItemIdHTML() {
		return componentItemIdHTML;
	}

	public void setComponentItemIdHTML(String componentItemIdHTML) {
		this.componentItemIdHTML = componentItemIdHTML;
	}

	public String getComponentValue() {
		return componentValue;
	}

	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	
	public AppComponent getAppComponent() {
		return appComponent;
	}

	public void setAppComponent(AppComponent appComponent) {
		this.appComponent = appComponent;
	}

	@Override
	public String toString() {
		return "ComponentItem [componentItemId=" + componentItemId + ", comoponentItemIdHTML=" + componentItemIdHTML
				+ ", componentValue=" + componentValue + "]";
	}
}
