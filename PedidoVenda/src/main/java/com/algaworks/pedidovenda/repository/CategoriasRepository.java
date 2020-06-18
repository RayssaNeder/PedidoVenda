package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriasRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	
	public List<Categoria> buscarTodas(){
		return manager.createQuery("from Categoria", Categoria.class).getResultList() ;
		
	}

}
