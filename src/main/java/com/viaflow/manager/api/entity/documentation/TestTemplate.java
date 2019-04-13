package com.viaflow.manager.api.entity.documentation;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.user.User;

@Document
public class TestTemplate extends DTOBase {

	@Id
	private String testTemplateId;

	@NotEmpty
	private String testTemplateName;

	@DBRef
	@NotEmpty
	private TestPlan testPlan;

	@DBRef
	private User testTemplateUser;

	public String getTestTemplateId() {
		return testTemplateId;
	}

	public void setTestTemplateId(String testTemplateId) {
		this.testTemplateId = testTemplateId;
	}

	public String getTestTemplateName() {
		return testTemplateName;
	}

	public void setTestTemplateName(String testTemplateName) {
		this.testTemplateName = testTemplateName;
	}

	public TestPlan getTestPlan() {
		return testPlan;
	}

	public void setTestPlan(TestPlan testPlan) {
		this.testPlan = testPlan;
	}

	public User getTestTemplateUser() {
		return testTemplateUser;
	}

	public void setTestTemplateUser(User testTemplateUser) {
		this.testTemplateUser = testTemplateUser;
	}

	@Override
	public String toString() {
		return "TestTemplate [testTemplateId=" + testTemplateId + ", testTemplateName=" + testTemplateName
				+ ", testPlan=" + testPlan + ", testTemplateUser=" + testTemplateUser + "]";
	}
}
