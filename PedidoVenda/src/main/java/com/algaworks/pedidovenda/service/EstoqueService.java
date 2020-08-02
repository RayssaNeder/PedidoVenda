package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.repository.PedidosRepository;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class EstoqueService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidosRepository pedidosRepository;
	
	@Transactional
	public void baixarEstoque(Pedido pedido) {
		pedido = this.pedidosRepository.porId(pedido.getId());
		
		for(ItemPedido item : pedido.getItensPedido()) {
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
		
	}

}
