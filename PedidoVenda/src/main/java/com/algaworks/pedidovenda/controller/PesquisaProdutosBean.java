package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.ProdutosRepository;
import com.algaworks.pedidovenda.repository.filter.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Produto> produtosFiltrados;
	
	@Inject
	private ProdutosRepository produtosRepository;
	
	private ProdutoFilter produtoFilter;
	
	public PesquisaProdutosBean() {
		this.produtoFilter = new ProdutoFilter();
	}
	
	
	public void pesquisar() {		
		produtosFiltrados = produtosRepository.filtrados(produtoFilter);				
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getProdutoFilter() {
		return produtoFilter;
	}

	
	
	
	

}
