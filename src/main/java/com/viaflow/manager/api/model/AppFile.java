package com.viaflow.manager.api.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

public class AppFile {
	
	@TextIndexed
	private String fileName;
	
	@TextIndexed
	private String extensionName;
	
	private String data;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExtensionName() {
		return extensionName;
	}

	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AppFile [fileName=" + fileName + ", extensionName=" + extensionName + "]";
	}

}

