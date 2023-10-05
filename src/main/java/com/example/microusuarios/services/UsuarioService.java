package com.example.microusuarios.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microusuarios.dto.RoleDTO;
import com.example.microusuarios.dto.UsuarioDTO;
import com.example.microusuarios.interfaces.IUsuarioService;
import com.example.microusuarios.model.Role;
import com.example.microusuarios.model.Usuario;
import com.example.microusuarios.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<UsuarioDTO> getUsuarios() {
		List<UsuarioDTO> usuariosDto = new ArrayList<>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for (Usuario usuario : usuarios) {
			Set<Role> roles = usuario.getRoles();
			List<RoleDTO> rolesDto = new ArrayList<>();
			if(roles != null) {
				for (Role role : roles) {
					RoleDTO roleDto = new RoleDTO(role.getRole(), role.getFuncion());
					rolesDto.add(roleDto);
				}
				
			}
			
			UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getUser(), usuario.getEmail(), usuario.getPassword(),rolesDto);
			
			usuariosDto.add(usuarioDto);
		}
		return usuariosDto;
	}

	@Override
	public UsuarioDTO getUsuarioByUser(String user) {
		Usuario usuario = usuarioRepository.findById(user).orElse(null);
		UsuarioDTO usuarioDto = null;
		if (usuario != null) {
			Set<Role> roles = usuario.getRoles();
			List<RoleDTO> rolesDto = new ArrayList<>();
			if(roles != null) {
				for (Role role : roles) {
					RoleDTO roleDto = new RoleDTO(role.getRole(), role.getFuncion());
					rolesDto.add(roleDto);
				}
				
			}
			
			usuarioDto = new UsuarioDTO(usuario.getUser(), usuario.getEmail(), usuario.getPassword(), rolesDto);
		}
		return usuarioDto;
	}

	@Override
	public void addUsuario(UsuarioDTO usuarioDto) {
		
		Usuario usuario = new Usuario(usuarioDto.getUser(), usuarioDto.getEmail(), usuarioDto.getPassword());
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void deleteUsuarioByUser(String user) {
		usuarioRepository.deleteById(user);
		
	}

	@Override
	public void updateUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario(usuarioDto.getUser(), usuarioDto.getEmail(), usuarioDto.getPassword());
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void addRole(UsuarioDTO usuarioDTO, RoleDTO role) {
		List<RoleDTO> rolesDTO = usuarioDTO.getRolesDTO();
		rolesDTO.add(role);
		usuarioDTO.setRolesDTO(rolesDTO);
		
		updateUsuario(usuarioDTO);
		
	}

}
