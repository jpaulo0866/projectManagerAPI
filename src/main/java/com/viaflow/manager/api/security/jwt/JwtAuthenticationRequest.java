package com.viaflow.manager.api.security.jwt;

public class JwtAuthenticationRequest {
	
	private String login;
	private String password;
	
	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
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
	
	
}
