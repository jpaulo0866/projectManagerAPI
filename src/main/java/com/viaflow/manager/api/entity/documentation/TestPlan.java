package com.viaflow.manager.api.entity.documentation;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.project.us.UserStory;
import com.viaflow.manager.api.entity.user.User;

@Document
public class TestPlan extends DTOBase {

	@Id
	private String testPlanId;

	@NotEmpty
	private String testPlanName;

	@DBRef
	private Project project;

	@DBRef
	@NotEmpty
	private UserStory userStory;

	@DBRef
	@NotEmpty
	List<TestDescription> testDescription;

	@DBRef
	@NotEmpty
	private User userLogger;

	@DBRef
	@NotEmpty
	private User userResponse;

	public String getTestPlanId() {
		return testPlanId;
	}

	public void setTestPlanId(String testPlanId) {
		this.testPlanId = testPlanId;
	}

	public String getTestPlanName() {
		return testPlanName;
	}

	public void setTestPlanName(String testPlanName) {
		this.testPlanName = testPlanName;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	public List<TestDescription> getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(List<TestDescription> testDescription) {
		this.testDescription = testDescription;
	}

	public User getUserLogger() {
		return userLogger;
	}

	public void setUserLogger(User userLogger) {
		this.userLogger = userLogger;
	}

	public User getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(User userResponse) {
		this.userResponse = userResponse;
	}

	@Override
	public String toString() {
		return "TestPlan [testPlanId=" + testPlanId + ", testPlanName=" + testPlanName + ", userStory=" + userStory
				+ ", testDescription=" + testDescription + ", userLogger=" + userLogger + ", userResponse="
				+ userResponse + "]";
	}
}
