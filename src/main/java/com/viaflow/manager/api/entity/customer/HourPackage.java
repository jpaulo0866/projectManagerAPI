package com.viaflow.manager.api.entity.customer;

import org.springframework.data.mongodb.core.index.TextIndexed;

import com.viaflow.manager.api.entity.base.DTOBase;

public class HourPackage extends DTOBase {

	@TextIndexed
	private String hourPackageName;

	private double hourPackageAmountHour;

	public String getHourPackageName() {
		return hourPackageName;
	}

	public void setHourPackageName(String hourPackageName) {
		this.hourPackageName = hourPackageName;
	}

	public double getHourPackageAmountHour() {
		return hourPackageAmountHour;
	}

	public void setHourPackageAmountHour(double hourPackageAmountHour) {
		this.hourPackageAmountHour = hourPackageAmountHour;
	}
}
