package com.viaflow.manager.api.entity.permission;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class TypePermission extends DTOBase {

	@Id
	private String typePermissionId;

	@Indexed(unique = true)
	@NotEmpty
	private String typePermissionName;

	public String getTypePermissionId() {
		return typePermissionId;
	}

	public void setTypePermissionId(String typePermissionId) {
		this.typePermissionId = typePermissionId;
	}

	public String getTypePermissionName() {
		return typePermissionName;
	}

	public void setTypePermissionName(String typePermissionNome) {
		this.typePermissionName = typePermissionNome;
	}

	@Override
	public String toString() {
		return "TypePermission [typePermissionId=" + typePermissionId + ", nome=" + typePermissionName + "]";
	}

}
