package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.repository.ProdutosRepository;
import com.algaworks.pedidovenda.service.CadastroProdutoService;
import com.algaworks.pedidovenda.util.jpa.EntityManagerProducer;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriasRepository categoriasRepository;
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	private Produto produto;
	private List<Categoria> categorias;
	private List<Categoria> subcategorias;
	
	@NotNull
	private Categoria categoria;
	
	
	
	public CadastroProdutoBean() {
		limpar();
	}
	
	public void inicializar() {
		System.out.println("Inicializando lista de categorias");
		
		if(FacesUtil.isNotPostBack()) {
			this.categorias = categoriasRepository.buscarTodas();
		}
		
		if(this.categoria != null) {
			carregaSubCategorias();
		}
		
	}
	
	public void carregaSubCategorias() {
		this.subcategorias = categoriasRepository.buscarTodasSubcategorias(this.categoria);
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}
	
	private void limpar() {
		this.produto = new Produto();
		categoria = null;
		subcategorias = new ArrayList<>();
	}

	public Produto getProduto() {
		return produto;
	}
	
	

	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if(this.produto != null) {
			this.categoria = produto.getCategoria().getCategoriaPai();	
		}
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}
	
	
	
	
	
	

}
