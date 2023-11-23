package com.api.controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.daos.Usuario;
import com.api.servicios.UsuarioServicio;

/**
 * Clase que actua como controlador para la entidad Usuario
 */
@RestController // RestController Define que la clase es un controlador
@RequestMapping("/usuarios") // Define el prefijo de la URL para todos los métodos en este controlador
@CrossOrigin(origins = "*") // Cambia esto por la URL de tu aplicación web
public class UsuarioControlador {

	// Autowired Inyecta la dependencia instanciada lista para usar
	@Autowired 
	private UsuarioServicio usuarioServicio;

	// GetMapping Define el endpoint al navegar para obtener todos los usuarios (usuarios/todos)
	@GetMapping 
	public ArrayList<Usuario> obtenerTodosUsuarios() {
		return usuarioServicio.obtenerTodos();
	}

	// La anotación @PathVariable mapea una parte de la URL de una
	// solicitud HTTP a un parámetro de un método en un controlador en este caso el
	// id (http://localhost/usuarios/id/elidquesea)
	@GetMapping("/id/{id}")
	public Optional<Usuario> obtenerPorId(@PathVariable("id") long id) {
		return usuarioServicio.obtenerPorID(id);
	}
	
	 @PostMapping
	 public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario nuevoUsuario) {
	     Usuario usuarioGuardado = usuarioServicio.guardarUsuario(nuevoUsuario);
	     return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
	 }

}
