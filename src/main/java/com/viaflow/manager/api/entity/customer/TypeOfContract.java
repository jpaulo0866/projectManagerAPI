package com.viaflow.manager.api.entity.customer;

import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class TypeOfContract extends DTOBase {

	@Id
	private String typeOfContractId;

	@Indexed(unique = true)
	@NotEmpty
	@TextIndexed
	private String typeOfContractName;

	private boolean disabled;

	public String getTypeOfContractId() {
		return typeOfContractId;
	}

	public void setTypeOfContractId(String typeOfContractId) {
		this.typeOfContractId = typeOfContractId;
	}

	public String getTypeOfContractName() {
		return typeOfContractName;
	}

	public void setTypeOfContractName(String typeOfContractName) {
		this.typeOfContractName = typeOfContractName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "TypeOfContract [typeOfContractId=" + typeOfContractId + ", typeOfContractName=" + typeOfContractName
				+ ", disabled=" + disabled + "]";
	}
}
