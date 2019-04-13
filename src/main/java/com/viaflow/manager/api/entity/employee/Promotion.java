package com.viaflow.manager.api.entity.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class Promotion extends DTOBase {

	@Id
	private String promotionId;

	@DBRef
	private Employee employee;

	@DBRef
	private Role oldRole;

	@DBRef
	private Role newRole;

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getOldRole() {
		return oldRole;
	}

	public void setOldRole(Role oldRole) {
		this.oldRole = oldRole;
	}

	public Role getNewRole() {
		return newRole;
	}

	public void setNewRole(Role newRole) {
		this.newRole = newRole;
	}

	@Override
	public String toString() {
		return "Promotion [promotionId=" + promotionId + ", employee=" + employee + ", oldRole=" + oldRole
				+ ", newRole=" + newRole + "]";
	}
}
