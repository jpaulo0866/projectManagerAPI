package com.viaflow.manager.api.entity.customer;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.person.Contact;
import com.viaflow.manager.api.entity.user.User;
import com.viaflow.manager.api.model.Address;

@Document
public class Customer extends DTOBase {

	@Id
	private String customerId;

	@NotEmpty
	@Indexed(unique = true)
	@TextIndexed
	private String customerCnpj;

	@NotEmpty
	@TextIndexed
	private String customerName;

	private boolean disabled;

	@DBRef
	private User customerUserManager;

	private List<Address> customerAddress;

	private List<Contact> customerContacts;

	@DBRef
	private List<Contract> contracts;

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCnpj() {
		return customerCnpj;
	}

	public void setCustomerCnpj(String customerCnpj) {
		this.customerCnpj = customerCnpj;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public User getCustomerUserManager() {
		return customerUserManager;
	}

	public void setCustomerUserManager(User customerUserManager) {
		this.customerUserManager = customerUserManager;
	}

	public List<Address> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<Address> customerAdress) {
		this.customerAddress = customerAdress;
	}

	public List<Contact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(List<Contact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCnpj=" + customerCnpj + ", customerName="
				+ customerName + ", disabled=" + disabled + ", customerUserManager=" + customerUserManager
				+ ", customerAdress=" + customerAddress + ", customerContacts=" + customerContacts + "]";
	}

}
