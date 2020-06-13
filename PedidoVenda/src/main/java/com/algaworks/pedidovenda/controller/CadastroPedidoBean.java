package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.EnderecoEntrega;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.service.NegocioException;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> itens;
	
	private Pedido pedido;
	
	public CadastroPedidoBean() {
		pedido = new Pedido();
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		pedido.setEnderecoEntrega(enderecoEntrega);
		itens = new ArrayList<>();
		itens.add(1);
	}
	
	

	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public List<Integer> getItens() {
		return itens;
	}
	
	public void salvar(){
		throw new NegocioException("Pedido não salvo.Implementação em andamento");
	}

}
