package com.viaflow.manager.api.entity.user;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.viaflow.manager.api.entity.base.DTOBase;
import com.viaflow.manager.api.entity.person.Person;
import com.viaflow.manager.api.entity.user.Profile;

@Document
public class User extends DTOBase {

	@Id
	private String userId;

	private boolean ldapUser;

	@Indexed(unique = true)
	@TextIndexed
	private String login;

	private String password;

	@DBRef
	private Person person;

	@DBRef
	@NotEmpty
	private Profile profile;

	private boolean disabled;

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isLdapUser() {
		return ldapUser;
	}

	public void setLdapUser(boolean ldapUser) {
		this.ldapUser = ldapUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", ldapUser=" + ldapUser + ", login=" + login + ", password=" + password
				+ ", person=" + person + ", profile=" + profile + ", disabled=" + disabled + "]";
	}
}
