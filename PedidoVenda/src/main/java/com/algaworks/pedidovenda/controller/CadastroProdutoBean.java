package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.util.jpa.EntityManagerProducer;

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
	
	public CadastroProdutoBean() {
		produto = new Produto();
	}
	
	public void inicializar() {
		System.out.println("Inicializando lista de categorias");
		
		this.categorias = categoriasRepository.buscarTodas();
				
	}

	public void Salvar() {
		throw new RuntimeException("Teste de exceção");
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
	
	

}
