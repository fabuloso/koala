package io.koala.view;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public final class LoginBean {
	private final String username;
	private final String password;

	public LoginBean() {
		this.username = "admin";
		this.password = "password";
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}
}
