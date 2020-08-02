package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.StatusPedido;
import com.algaworks.pedidovenda.repository.PedidosRepository;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	@Inject
	private PedidosRepository pedidosRepository;
	
	@Inject
	private EstoqueService estoqueService;
	
	@Transactional
	public Pedido emitir(Pedido pedido) {
		pedido = this.cadastroPedidoService.salvarPedido(pedido);
		
		if(pedido.isNaoEmissivel()) {
			throw new NegocioException("Pedido não pode ser emitido com status " + pedido.getStatusPedido().getDescricao());		
		}
		
		this.estoqueService.baixarEstoque(pedido);
		
		pedido.setStatusPedido(StatusPedido.EMITIDO);
		
		pedido = this.pedidosRepository.salvar(pedido);
		
		return pedido;
	}

}
