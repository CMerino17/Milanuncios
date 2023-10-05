package com.example.microusuarios.dto;

import java.util.List;


public class RoleDTO {
	
	private String role;
	private String funcion;
	

	public RoleDTO(String role, String funcion) {
		super();
		this.role = role;
		this.funcion = funcion;
	}

	public RoleDTO(String role) {
		super();
		this.role = role;
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
		return "RoleDTO [role=" + role + ", funcion=" + funcion + ", usuariosDTO=" +  "]";
	}
	
	
	
}
