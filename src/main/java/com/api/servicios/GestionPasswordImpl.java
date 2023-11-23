package com.api.servicios;

import org.springframework.stereotype.Service;

import com.password4j.Hash;
import com.password4j.Password;

/**
 * Servicio de gestión de contraseñas que implementa la interfaz GestionPasswordService
 */
@Service
public class GestionPasswordImpl implements GestionPasswordService {

	@Override
	public String encriptarContraseña(String contraseña) {
		Hash hash = Password.hash(contraseña).withBcrypt();
		return hash.getResult();
	}

	@Override
	public boolean verificarContraseña(String contraseñaIngresada, String contraseñaAlmacenada) {
		if (contraseñaIngresada == contraseñaAlmacenada) 
			return true;
		else
			return false;
	}

}
