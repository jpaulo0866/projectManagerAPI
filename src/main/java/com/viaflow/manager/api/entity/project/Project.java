package com.viaflow.manager.api.entity.project;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.customer.Contract;
import com.viaflow.manager.api.entity.person.Person;
import com.viaflow.manager.api.entity.stage.ProjectStage;
import com.viaflow.manager.api.entity.user.Team;
import com.viaflow.manager.api.entity.user.User;

@Document
public class Project extends DTOBase {

	@Id
	private String projectId;

	@NotEmpty
	private String projectTitle;

	@NotEmpty
	private String projectDescription;

	@NotEmpty
	@DBRef
	private User projectUser;

	@NotEmpty
	@DBRef
	private Contract projectContract;

	@NotEmpty
	@DBRef
	private ProjectType projectType;

	@NotEmpty
	@DBRef
	private Status projectStatus;

	@NotEmpty
	@DBRef
	private ProjectStage projectStage;

	@NotEmpty
	@DBRef
	private ProjectPriority projectPriority;

	@DBRef
	private User ownerUser;

	@DBRef
	private Team ownerTeam;

	private String template;

	@Transient
	private List<ChangeProjectStatus> changeProjectStatus;

	@Transient
	private List<ChangeProjectUser> changeProjectUsers;

	@Transient
	private List<ChangeProjectTeam> changeProjectTeams;

	@Transient
	private List<ChangeProjectStage> changeProjectStages;

	private Date projectExpirationDate;

	private Date projectProposalDate;

	private Date projectDeadline;
	
	@CreatedDate
	private Date projectDate;

	private double projectInvestment;

	private User Analyst;

	private User userBusinessArea;

	private Person responsibleBusinessArea;

	private String businessArea;

	private Person responsibleTI;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}
	public Date getProjectDate() {
		return projectDate;
	}

	public void setProjectDate(Date projectDate) {
		this.projectDate = projectDate;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public User getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(User projectUser) {
		this.projectUser = projectUser;
	}

	public Contract getProjectContract() {
		return projectContract;
	}

	public void setProjectContract(Contract projectContract) {
		this.projectContract = projectContract;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public Status getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Status projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ProjectPriority getProjectPriority() {
		return projectPriority;
	}

	public void setProjectPriority(ProjectPriority projectPriority) {
		this.projectPriority = projectPriority;
	}

	public User getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}

	public Team getOwnerTeam() {
		return ownerTeam;
	}

	public void setOwnerTeam(Team ownerTeam) {
		this.ownerTeam = ownerTeam;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<ChangeProjectStatus> getChangeProjectStatus() {
		return changeProjectStatus;
	}

	public void setChangeProjectStatus(List<ChangeProjectStatus> changeProjectStatus) {
		this.changeProjectStatus = changeProjectStatus;
	}

	public List<ChangeProjectUser> getChangeProjectUsers() {
		return changeProjectUsers;
	}

	public void setChangeProjectUsers(List<ChangeProjectUser> changeProjectUsers) {
		this.changeProjectUsers = changeProjectUsers;
	}

	public List<ChangeProjectTeam> getChangeProjectTeams() {
		return changeProjectTeams;
	}

	public void setChangeProjectTeams(List<ChangeProjectTeam> changeProjectTeams) {
		this.changeProjectTeams = changeProjectTeams;
	}

	public List<ChangeProjectStage> getChangeProjectStages() {
		return changeProjectStages;
	}

	public void setChangeProjectStages(List<ChangeProjectStage> changeProjectStages) {
		this.changeProjectStages = changeProjectStages;
	}

	public ProjectStage getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(ProjectStage projectStage) {
		this.projectStage = projectStage;
	}

	public Date getProjectExpirationDate() {
		return projectExpirationDate;
	}

	public void setProjectExpirationDate(Date projectExpirationDate) {
		this.projectExpirationDate = projectExpirationDate;
	}

	public Date getProjectProposalDate() {
		return projectProposalDate;
	}

	public void setProjectProposalDate(Date projectProposalDate) {
		this.projectProposalDate = projectProposalDate;
	}

	public Date getProjectDeadline() {
		return projectDeadline;
	}

	public void setProjectDeadline(Date projectDeadline) {
		this.projectDeadline = projectDeadline;
	}

	public double getProjectInvestment() {
		return projectInvestment;
	}

	public void setProjectInvestment(double projectInvestment) {
		this.projectInvestment = projectInvestment;
	}

	public User getAnalyst() {
		return Analyst;
	}

	public void setAnalyst(User analyst) {
		Analyst = analyst;
	}

	public User getUserBusinessArea() {
		return userBusinessArea;
	}

	public void setUserBusinessArea(User userBusinessArea) {
		this.userBusinessArea = userBusinessArea;
	}

	public Person getResponsibleBusinessArea() {
		return responsibleBusinessArea;
	}

	public void setResponsibleBusinessArea(Person responsibleBusinessArea) {
		this.responsibleBusinessArea = responsibleBusinessArea;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public Person getResponsibleTI() {
		return responsibleTI;
	}

	public void setResponsibleTI(Person responsibleTI) {
		this.responsibleTI = responsibleTI;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDescription="
				+ projectDescription + ", projectUser=" + projectUser + ", projectContract=" + projectContract
				+ ", projectType=" + projectType + ", projectStatus=" + projectStatus + ", projectStage=" + projectStage
				+ ", projectPriority=" + projectPriority + ", ownerUser=" + ownerUser + ", ownerTeam=" + ownerTeam
				+ ", template=" + template + ", changeProjectStatus=" + changeProjectStatus + ", changeProjectUsers="
				+ changeProjectUsers + ", changeProjectTeams=" + changeProjectTeams + ", changeProjectStages="
				+ changeProjectStages + ", projectExpirationDate=" + projectExpirationDate + ", projectProposalDate="
				+ projectProposalDate + ", projectDeadline=" + projectDeadline + ", projectInvestment="
				+ projectInvestment + ", Analyst=" + Analyst + ", userBusinessArea=" + userBusinessArea
				+ ", responsibleBusinessArea=" + responsibleBusinessArea + ", businessArea=" + businessArea
				+ ", responsibleTI=" + responsibleTI + "]";
	}
}
