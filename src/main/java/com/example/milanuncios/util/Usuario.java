package com.example.milanuncios.util;

import java.util.List;

public class Usuario {

	private String user;

	private String email;

	private String password;

	private List<Role> roles;

	public Usuario() {
		super();
	}

	public Usuario(String user, String email, String password, List<Role> roles) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [user=" + user + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
