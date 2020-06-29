package com.algaworks.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import com.algaworks.pedidovenda.model.Produto;

public class ProdutosRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	
	
	public Produto salvar(Produto produto) {
		EntityTransaction trx = manager.getTransaction(); 
		trx.begin();
		manager.merge(produto);
		trx.commit();
		return produto;
	}


	public Produto porSKU(String sku) {
		try {
			return manager.createQuery("from Produto where upper(sku) = :sku", Produto.class).setParameter("sku", sku.toUpperCase()).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		}
}
