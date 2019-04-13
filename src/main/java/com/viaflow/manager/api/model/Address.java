package com.viaflow.manager.api.model;

import org.springframework.data.mongodb.core.index.TextIndexed;

public class Address {
	
	@TextIndexed
	private String addressStreet;
	
	@TextIndexed
	private String addressCity;
	
	@TextIndexed
	private String addressDistrict;
	
	@TextIndexed
	private String addressNumber;
	
	@TextIndexed
	private String addressZipCode;
	
	@TextIndexed
	private String countryAddress;
	
	private boolean disabled;

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressDistrict() {
		return addressDistrict;
	}

	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getCountryAddress() {
		return countryAddress;
	}

	public void setCountryAddress(String countryAddress) {
		this.countryAddress = countryAddress;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}



}
