package com.viaflow.manager.api.entity.comment;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.project.Project;
import com.viaflow.manager.api.entity.user.User;

@Document
public class Comment extends DTOBase {

	@Id
	private String comentId;

	@DBRef
	private Project project;

	@DBRef
	private User user;

	@NotEmpty
	private String comment;

	public String getComentId() {
		return comentId;
	}

	public void setComentId(String comentId) {
		this.comentId = comentId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Coment [comentId=" + comentId + ", project=" + project + ", user=" + user + ", comment=" + comment
				+ ", date=" + "]";
	}
}
