package com.example.milanuncios.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.milanuncios.util.Usuario;
import com.example.milanuncios.util.Usuario_v;

@FeignClient("/microusuarios/api/usuarios")
public interface IUsuarioService {

	@GetMapping
	public List<Usuario> getUsers();
	
	@GetMapping("/{id_usuario}")
	public Usuario getUserById(@PathVariable String id_usuario);
	
	@PostMapping
	public int addUsuario(@RequestBody Usuario_v usuario_v);
	
	@DeleteMapping("/{id_usuario}")
	public int deleteUsuario(@PathVariable String id_usuario);
	
	@PutMapping
	public int updateUsuario(@RequestBody Usuario_v usuario_v);
	
	@PostMapping("/login")
	public int loginUsuario(@RequestBody Usuario_v usuario_v);
}
