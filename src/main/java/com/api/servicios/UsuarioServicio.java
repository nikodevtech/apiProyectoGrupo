package com.api.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.daos.Usuario;

/**
 * Clase servicio que proporciona métodos para interactuar con la entidad Usuario en la base de datos.
 */
@Service
public class UsuarioServicio {
	
	@Autowired //Inyecta la dependencia instanciada
	private UsuarioRepositorio usuarioRepositorio;
	
	/**
	 * Acceso a la base de datos para obtener todos los usuarios
	 * @return ArrayList<Usuario> con los usuarios
	 */
	public ArrayList<Usuario> obtenerTodos() {
		return (ArrayList<Usuario>) usuarioRepositorio.findAll();
	}
	
	/**
	 * Acceso a la base de datos para obtener un usuario por su id 
	 * @param id
	 * @return Optional<Usuario> usuario buscado por id
	 */
	public Optional<Usuario> obtenerPorID(long id) {
		return usuarioRepositorio.findById(id);
	}
	
	/**
	 * Guarda un nuevo usuario en la base de datos
	 * @param usuario El usuario a guardar
	 * @return El usuario guardado
	 */
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	

}
