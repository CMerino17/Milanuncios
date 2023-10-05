package com.example.microusuarios.interfaces;

import java.util.List;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;

public interface IUsuarioService {

	public List<UsuarioDTO> getUsuarios();
	
	public UsuarioDTO getUsuarioByUser(String user);
	
	public void addUsuario(UsuarioDTO usuarioDto);
	
	public void deleteUsuarioByUser(String user);
	
	public void updateUsuario(UsuarioDTO usuarioDto);
	
	public void addRole(UsuarioDTO usuarioDTO, RoleDTO role);
}
