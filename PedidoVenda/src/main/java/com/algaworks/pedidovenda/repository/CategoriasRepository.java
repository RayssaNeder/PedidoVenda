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
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class).getResultList() ;
		
	}
	
	
	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}


	public List<Categoria> buscarTodasSubcategorias(Categoria categoriaPai) {
		return manager.createQuery("from Categoria where categoriaPai = :categoriaPai", Categoria.class).setParameter("categoriaPai", categoriaPai).getResultList() ;
	}

}
