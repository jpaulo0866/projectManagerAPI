package com.viaflow.manager.api.entity.documentation;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;

@Document
public class TestDescription extends DTOBase {

	@Id
	private String testDescriptionId;

	@NotEmpty
	private String description;

	@NotEmpty
	private String expectedResult;

	public String getTestDescriptionId() {
		return testDescriptionId;
	}

	public void setTestDescriptionId(String testDescriptionId) {
		this.testDescriptionId = testDescriptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
}
