package com.viaflow.manager.api.entity.person;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class TypeContact extends DTOBase {

	@Id
	private String typeContactId;

	@NotEmpty
	@TextIndexed
	private String typeContactName;

	private boolean disabled;

	public String getTypeContactId() {
		return typeContactId;
	}

	public void setTypeContactId(String typeContactId) {
		this.typeContactId = typeContactId;
	}

	public String getTypeContactName() {
		return typeContactName;
	}

	public void setTypeContactName(String typeContactName) {
		this.typeContactName = typeContactName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "TypeContact [typeContactId=" + typeContactId + ", typeContactName=" + typeContactName + ", disabled="
				+ disabled + "]";
	}

}
