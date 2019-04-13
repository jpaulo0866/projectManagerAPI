package com.viaflow.manager.api.entity.customer;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.person.Person;

@Document
public class Contract extends DTOBase {

	@Id
	private String contractId;

	@NotEmpty
	@Indexed(unique = true)
	@TextIndexed
	private String contractName;

	private boolean disabled;

	@DBRef
	private TypeOfContract typeOfContract;

	@NotEmpty
	private HourPackage contractHourPackage;

	@DBRef
	private List<Person> contractRelatedPerson;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<Person> getContractRelatedPerson() {
		return contractRelatedPerson;
	}

	public void setContractRelatedPerson(List<Person> contractRelatedPerson) {
		this.contractRelatedPerson = contractRelatedPerson;
	}

	public HourPackage getContractHourPackage() {
		return contractHourPackage;
	}

	public void setContractHourPackage(HourPackage contractHourPackage) {
		this.contractHourPackage = contractHourPackage;
	}

	public TypeOfContract getTypeOfContract() {
		return typeOfContract;
	}

	public void setTypeOfContract(TypeOfContract typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractName=" + contractName + ", disabled=" + disabled
				+ ", typeOfContract=" + typeOfContract + ", contractHourPackage=" + contractHourPackage
				+ ", contractRelatedPerson=" + contractRelatedPerson + "]";
	}

}
