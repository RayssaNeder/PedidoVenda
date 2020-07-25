package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.EnderecoEntrega;
import com.algaworks.pedidovenda.model.FormaPagamento;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.ClienteRepository;
import com.algaworks.pedidovenda.repository.UsuariosRepository;
import com.algaworks.pedidovenda.service.CadastroPedidoService;
import com.algaworks.pedidovenda.service.NegocioException;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pedido pedido;
	private List<Usuario> vendedores;
	
	@Inject
	private ClienteRepository clienteRepository;
	
	@Inject
	private UsuariosRepository usuariosRepository;
	
	@Inject
	private CadastroPedidoService cadastroPedidoService;
	
	public List<Cliente> completarCliente(String nome) {
		return this.clienteRepository.porNome(nome);
	}
	
	public FormaPagamento[] getFormasPagamento(){
		return FormaPagamento.values();
	}
	
	public CadastroPedidoBean() {
		limpar();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
		this.vendedores = usuariosRepository.vendedores();
		}
	}
	
	public void limpar() {
		pedido = new Pedido();
		EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
		pedido.setEnderecoEntrega(enderecoEntrega);
	}
	

	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public void salvar(){
		this.pedido = cadastroPedidoService.salvarPedido(pedido);
		FacesUtil.addInfoMessage("Pedido salvo com sucesso.");
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}
	
	

}
