package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.service.NegocioException;


@Named
@ViewScoped
@RequestScoped
public class CadastroPedidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> itens;
	
	public CadastroPedidoBean() {
		itens = new ArrayList<>();
		itens.add(1);
	}

	public List<Integer> getItens() {
		return itens;
	}
	
	public void salvar(){
		throw new NegocioException("Pedido não salvo.Implementação em andamento");
	}

}
