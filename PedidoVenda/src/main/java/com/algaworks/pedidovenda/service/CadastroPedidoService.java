package com.algaworks.pedidovenda.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.StatusPedido;
import com.algaworks.pedidovenda.repository.PedidosRepository;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroPedidoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidosRepository pedidoRepository;
	
	@Transactional
	public Pedido salvarPedido(Pedido pedido) {
		if(pedido.isNovo()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatusPedido(StatusPedido.ORCAMENTO);
		}
		
		pedido.recalcularValorTotal();
		
		if(pedido.getItensPedido().isEmpty()) {
			throw new NegocioException("O pedido deve possuir pelo menos um item.");
		}
		
		if(pedido.isValorTotalNegativo()) {
			throw new NegocioException("Valor total do pedido não pode se negativo");
		}
		
		pedido =  pedidoRepository.salvar(pedido);
		return pedido;
		
	}

}
