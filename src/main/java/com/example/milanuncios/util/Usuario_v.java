package com.example.milanuncios.util;

import java.util.List;

public class Usuario_v {
	
	private String user;

	private String email;

	private String password;

	private String rol1;
	
	private String descripcion1;
	private String rol2;
	private String descripcion2;
	public Usuario_v() {
		super();
	}
	public Usuario_v(String user, String email, String password) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
	}
	public Usuario_v(String user, String email, String password, String rol1, String descripcion1, String rol2,
			String descripcion2) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.rol1 = rol1;
		this.descripcion1 = descripcion1;
		this.rol2 = rol2;
		this.descripcion2 = descripcion2;
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
	public String getRol1() {
		return rol1;
	}
	public void setRol1(String rol1) {
		this.rol1 = rol1;
	}
	public String getDescripcion1() {
		return descripcion1;
	}
	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}
	public String getRol2() {
		return rol2;
	}
	public void setRol2(String rol2) {
		this.rol2 = rol2;
	}
	public String getDescripcion2() {
		return descripcion2;
	}
	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}
	@Override
	public String toString() {
		return "Usuario_v [user=" + user + ", email=" + email + ", password=" + password + ", rol1=" + rol1
				+ ", descripcion1=" + descripcion1 + ", rol2=" + rol2 + ", descripcion2=" + descripcion2 + "]";
	}
	
	

}
