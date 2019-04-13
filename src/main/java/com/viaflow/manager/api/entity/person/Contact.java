package com.viaflow.manager.api.entity.person;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class Contact extends DTOBase {

	@Id
	private String contactId;

	@NotBlank
	@TextIndexed
	private String value;

	private boolean disabled;

	@DBRef
	private TypeContact typeContact;

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public TypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(TypeContact typeContact) {
		this.typeContact = typeContact;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", value=" + value + ", disabled=" + disabled + ", typeContact="
				+ typeContact + "]";
	}
}
