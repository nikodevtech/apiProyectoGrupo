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
	
	@Autowired 
	private GestionPasswordService gestionPasswordService;
	
	/**
	 * Acceso a la base de datos para obtener todos los usuarios
	 * @return ArrayList lista con los usuarios registrados
	 */
	public ArrayList<Usuario> obtenerTodos() {
		return (ArrayList<Usuario>) usuarioRepositorio.findAll();
	}
	
	/**
	 * Acceso a la base de datos para obtener un usuario por su id 
	 * @param id del usuario a obtener 
	 * @return Optional usuario buscado por id
	 */
	public Optional<Usuario> obtenerPorID(long id) {
		return usuarioRepositorio.findById(id);
	}
	
	  /**
     * Guarda un nuevo usuario en la base de datos.
     * @param usuario El usuario a guardar en la base de datos
     * @return El usuario guardado
     */
    public Usuario guardarUsuario(Usuario usuario) {
    	 // Verifica si el usuario ya existe antes de guardarlo
        if (!existeUsuarioConDNI(usuario.getDniUsuario())) {
            usuario.setClaveUsuario(gestionPasswordService.encriptarContraseña(usuario.getClaveUsuario()));
            return usuarioRepositorio.save(usuario);
        } else {
            // Manejar la lógica de error, por ejemplo, lanzar una excepción o devolver null
            // Puedes personalizar esto según tus necesidades.
            throw new RuntimeException("Ya existe un usuario con el DNI proporcionado");
        }
    }
	
    /**
     * Verifica si un usuario con el DNI especificado ya existe en la base de datos.
     * @param dni El DNI del usuario a verificar
     * @return true si el usuario existe, false si no existe
     */
    public boolean existeUsuarioConDNI(String dni) {
        Optional<Usuario> usuarioExistente = usuarioRepositorio.findByDniUsuario(dni);
        return usuarioExistente.isPresent();
    }

	
	

}
