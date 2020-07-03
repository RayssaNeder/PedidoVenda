package com.algaworks.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Usuario;

public class UsuariosRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	EntityManager manager;
	
	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}

}
