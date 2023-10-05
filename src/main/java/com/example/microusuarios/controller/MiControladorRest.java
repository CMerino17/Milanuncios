package com.example.microusuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class MiControladorRest {

	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getUsers(){
		return ResponseEntity.ok(usuarioService.getUsuarios());
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioDTO> getUserById(@PathVariable String id_usuario){
		if(usuarioService.getUsuarioByUser(id_usuario) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarioService.getUsuarioByUser(id_usuario));
	}
	
	@PostMapping
	public ResponseEntity<Integer> addUsuario(@RequestBody UsuarioDTO usuarioDto){
		if(usuarioService.getUsuarioByUser(usuarioDto.getUser()) == null) {
			usuarioService.addUsuario(usuarioDto);
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<Integer> deleteUsuario(@PathVariable String id_usuario){
		if(usuarioService.getUsuarioByUser(id_usuario) != null) {
			usuarioService.deleteUsuarioByUser(id_usuario);
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@PutMapping
	public ResponseEntity<Integer> updateUsuario(@RequestBody UsuarioDTO usuarioDto){
		if(usuarioService.getUsuarioByUser(usuarioDto.getUser()) != null) {
			usuarioService.updateUsuario(usuarioDto);
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> loginUsuario(@RequestBody UsuarioDTO usuarioDto){
		if(usuarioService.getUsuarioByUser(usuarioDto.getUser()).getPassword().equals(usuarioDto.getPassword())) {
			return ResponseEntity.ok(0);
		}
		return ResponseEntity.ok(1);
	}
	
	
}
