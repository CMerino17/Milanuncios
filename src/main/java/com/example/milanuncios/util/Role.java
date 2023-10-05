package com.example.milanuncios.util;

import java.util.List;

public class Role {

	private String role;

	private String funcion;


	public Role() {
		super();
	}

	public Role(String role, String funcion) {
		super();
		this.role = role;
		this.funcion = funcion;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", funcion=" + funcion + "]";
	}

	

	
}
