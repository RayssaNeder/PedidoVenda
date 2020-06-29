package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
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
	private Produto produto;
	private List<Categoria> categorias;
	private List<Categoria> subcategorias;
	
	@NotNull
	private Categoria categoria;
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando lista de categorias");
		
		if(FacesUtil.isNotPostBack()) {
			this.categorias = categoriasRepository.buscarTodas();
		}
				
	}
	
	public void carregaSubCategorias() {
		this.subcategorias = categoriasRepository.buscarTodasSubcategorias(this.categoria);
	}

	public void salvar() {
		System.out.println("Categoria selecionada" + this.categoria.getDescricao());
	}

	public Produto getProduto() {
		return produto;
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
	
	
	
	
	
	

}
