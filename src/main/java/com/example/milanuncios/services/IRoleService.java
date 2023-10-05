package com.example.milanuncios.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.milanuncios.util.Role;


public interface IRoleService {

	@GetMapping
	public List<Role> getRoles();
}
