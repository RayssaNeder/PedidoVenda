package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;
import com.algaworks.pedidovenda.service.NegocioException;

public class ProdutosRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	EntityManager manager;
	
	
	public Produto salvar(Produto produto) {
		return manager.merge(produto);
	}


	public Produto porSKU(String sku) {
		try {
			return manager.createQuery("from Produto where upper(sku) = :sku", Produto.class).setParameter("sku", sku.toUpperCase()).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		}


	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter produtoFilter) {		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		
		if(StringUtils.isNotBlank(produtoFilter.getSku())) {  //commons-lang3
			criteria.add(Restrictions.eq("sku", produtoFilter.getSku()));
		}
		if(StringUtils.isNotBlank(produtoFilter.getNome())) {
			criteria.add(Restrictions.ilike("nome", produtoFilter.getNome(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nome")).list();
		
	}


	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}
}
