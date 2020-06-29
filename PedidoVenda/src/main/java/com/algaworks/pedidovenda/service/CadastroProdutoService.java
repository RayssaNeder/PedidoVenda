package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.ProdutosRepository;

public class CadastroProdutoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	ProdutosRepository produtosRepositorio;

	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtosRepositorio.porSKU(produto.getSku());
		if (produtoExistente != null) {
			throw new NegocioException("Já existe um produdo cadastrado para o SKU informado");
		}
		return produtosRepositorio.salvar(produto);
	}

}
