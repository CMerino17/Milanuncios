package com.example.milanuncios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.milanuncios.services.IAnuncioService;
import com.example.milanuncios.services.ICategoriaService;
import com.example.milanuncios.services.IRoleService;
import com.example.milanuncios.services.IUsuarioService;
import com.example.milanuncios.util.Usuario;
import com.example.milanuncios.util.Usuario_v;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MiControlador {

	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	IAnuncioService anuncioService;
	
	@Autowired
	ICategoriaService categoriaService;
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/list_usuarios")
	public String getUsers(Model model) {
		List<Usuario>usuarios = usuarioService.getUsers();
		model.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
	
	@GetMapping("/nuevo_usuario")
	public String altaUsuario(Model model) {
		Usuario_v usuario_v= new Usuario_v();
		model.addAttribute("usuario_v", usuario_v);
		model.addAttribute("roles",roleService.getRoles());
		return "nuevo_jugador";
	}
	
	@PostMapping("/grabar_usuario")
	public String grabarUsuario(Usuario_v usuario_v, Model model) {
		if(usuarioService.addUsuario(usuario_v) == 1) {
			model.addAttribute("mensaje", "Usuario ya existente");
			return "nuevo_usuario";
		}
		return "index";
	}
	
	@DeleteMapping("/eliminar_usuario/{id_user}")
	public String eliminarUsuario(@PathVariable ("id_user")String id_user,  Model model) {
		usuarioService.deleteUsuario(id_user);
		model.addAttribute("usuarios",usuarioService.getUsers());
		return "list_usuarios";
	}
	
	@PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password, Model model,HttpServletRequest request) {
        // Validate user credentials against the database
        Usuario usuario = usuarioService.getUserById(user);

        if (usuario != null) {
        	HttpSession session=request.getSession(true);
        	session.setAttribute("username", user);
            return "index";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
	
}
