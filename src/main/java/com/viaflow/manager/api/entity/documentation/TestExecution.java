package com.viaflow.manager.api.entity.documentation;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

@Document
public class TestExecution extends DTOBase {

	@Id
	private String testExecutionId;

	@DBRef
	@NotEmpty
	private TestPlan testDescrition;

	@NotEmpty
	private String resultObtained;

	@DBRef
	@NotEmpty
	private User testExecutionUser;

	public String getTestExecutionId() {
		return testExecutionId;
	}

	public void setTestExecutionId(String testExecutionId) {
		this.testExecutionId = testExecutionId;
	}

	public TestPlan getTestDescrition() {
		return testDescrition;
	}

	public void setTestDescrition(TestPlan testDescrition) {
		this.testDescrition = testDescrition;
	}

	public String getResultObtained() {
		return resultObtained;
	}

	public void setResultObtained(String resultObtained) {
		this.resultObtained = resultObtained;
	}

	public User getTestExecutionUser() {
		return testExecutionUser;
	}

	public void setTestExecutionUser(User testExecutionUser) {
		this.testExecutionUser = testExecutionUser;
	}
}
