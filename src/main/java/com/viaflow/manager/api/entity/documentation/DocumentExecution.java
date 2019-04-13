package com.viaflow.manager.api.entity.documentation;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

@Document
public class DocumentExecution extends DTOBase {

	@Id
	private String documentExecutionId;

	@DBRef
	@NotEmpty
	private TestPlan documentExecutionTestPlan;

	@DBRef
	@NotEmpty
	private List<TestExecution> execution;

	@DBRef
	@NotEmpty
	private User documentExecutionExecutorUser;

	@NotEmpty
	private boolean conclusion;

	public String getDocumentExecutionId() {
		return documentExecutionId;
	}

	public void setDocumentExecutionId(String documentExecutionId) {
		this.documentExecutionId = documentExecutionId;
	}

	public TestPlan getDocumentExecutionTestPlan() {
		return documentExecutionTestPlan;
	}

	public void setDocumentExecutionTestPlan(TestPlan documentExecutionTestPlan) {
		this.documentExecutionTestPlan = documentExecutionTestPlan;
	}

	public List<TestExecution> getExecution() {
		return execution;
	}

	public void setExecution(List<TestExecution> execution) {
		this.execution = execution;
	}

	public User getDocumentExecutionExecutorUser() {
		return documentExecutionExecutorUser;
	}

	public void setDocumentExecutionExecutorUser(User documentExecutionExecutorUser) {
		this.documentExecutionExecutorUser = documentExecutionExecutorUser;
	}

	public boolean isConclusion() {
		return conclusion;
	}

	public void setConclusion(boolean conclusion) {
		this.conclusion = conclusion;
	}
}
