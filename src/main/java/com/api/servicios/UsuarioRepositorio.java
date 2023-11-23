package com.api.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.daos.Usuario;

//Indica que la interfaz es un componente de persistencia (un repositorio) y que debe ser escaneada y administrada por Spring
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	// Los repositorios se utilizan para interactuar con la base de datos de manera
	// eficiente, y la interfaz JpaRepository proporciona una serie de funcionalidades para
	// simplificar CRUD con bases de datos.
}
