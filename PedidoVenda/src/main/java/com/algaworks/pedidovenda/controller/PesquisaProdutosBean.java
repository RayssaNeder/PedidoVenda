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
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

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
	private Produto produtoSelecionado;
	private ProdutoFilter produtoFilter;
	
	public PesquisaProdutosBean() {
		this.produtoFilter = new ProdutoFilter();
	}
	
	
	public void pesquisar() {		
		produtosFiltrados = produtosRepository.filtrados(produtoFilter);				
	}
	
	public void excluir() {
		produtosRepository.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto " + produtoSelecionado.getSku() + "removido com sucesso");
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getProdutoFilter() {
		return produtoFilter;
	}


	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}


	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	
	
	
	

}
