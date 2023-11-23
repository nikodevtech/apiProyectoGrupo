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
 * Clase que actúa como controlador para la entidad Usuario.
 *
 * Esta clase define los endpoints relacionados con la entidad Usuario,
 * permitiendo la obtención de todos los usuarios, la obtención de un usuario
 * por su ID y la creación de un nuevo usuario.
 */
@RestController // RestController Define que la clase es un controlador
@RequestMapping("/usuarios") // Define el prefijo de la URL para todos los métodos en este controlador
@CrossOrigin(origins = "*") // Cambia esto por la URL de tu aplicación web
public class UsuarioControlador {

	// Autowired Inyecta la dependencia instanciada lista para usar
	@Autowired
	private UsuarioServicio usuarioServicio;

	/**
	 * Obtiene todos los usuarios.
	 * 
	 * @return Lista de todos los usuarios.
	 */
	@GetMapping // GetMapping Define el endpoint al navegar para obtener todos los usuarios
				// (usuarios/todos)
	public ArrayList<Usuario> obtenerTodosUsuarios() {
		return usuarioServicio.obtenerTodos();
	}

	/**
	 * Obtiene un usuario por su ID.
	 * 
	 * @param id ID del usuario.
	 * @return Usuario con el ID proporcionado, o un objeto Optional vacío si no se
	 *         encuentra.
	 */
	@GetMapping("/id/{id}") // @PathVariable mapea una parte de la URL de una solicitud HTTP a un parámetro
							// de u id
	public Optional<Usuario> obtenerPorId(@PathVariable("id") long id) {
		return usuarioServicio.obtenerPorID(id);
	}

	/**
	 * Guarda un nuevo usuario.
	 * 
	 * @param nuevoUsuario El nuevo usuario a ser guardado.
	 * @return ResponseEntity con el usuario guardado y el código de estado HTTP.
	 */
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario nuevoUsuario) {
		Usuario usuarioGuardado = usuarioServicio.guardarUsuario(nuevoUsuario);
		return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
	}

}
