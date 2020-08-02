package com.algaworks.pedidovenda.controller;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.converter.PedidoEdicao;
import com.algaworks.pedidovenda.events.PedidoAlteradoEvent;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.service.EmissaoPedidoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EmissaoPedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@PedidoEdicao
	private Pedido pedido;
	
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	@Inject
	
	private EmissaoPedidoService emissaoPedidoService;
	
	 public void emitirPedido() {
		 this.pedido.removerItemVazio();
		 
		 try {
			 this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			 this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido)); //para que o pedido seja atualizado no bean de cadastro
			 FacesUtil.addInfoMessage("Pedido emitido com sucesso!");
		 }finally {
			this.pedido.adicionarItemVazio();
		}
		 
	 }

}
