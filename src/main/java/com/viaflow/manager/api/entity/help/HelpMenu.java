package com.viaflow.manager.api.entity.help;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.component.AppComponent;

@Document
public class HelpMenu extends DTOBase {

	@Id
	private String helpMenuId;

	@DBRef
	private AppComponent component;

	private String templateHTML;

	public String getHelpMenuId() {
		return helpMenuId;
	}

	public void setHelpMenuId(String helpMenuId) {
		this.helpMenuId = helpMenuId;
	}

	public AppComponent getComponent() {
		return component;
	}

	public void setComponent(AppComponent component) {
		this.component = component;
	}

	public String getTemplateHTML() {
		return templateHTML;
	}

	public void setTemplateHTML(String templateHTML) {
		this.templateHTML = templateHTML;
	}

	@Override
	public String toString() {
		return "HelpMenu [helpMenuId=" + helpMenuId + ", appComponent=" + component + ", templateHTML=" + templateHTML
				+ "]";
	}

}
