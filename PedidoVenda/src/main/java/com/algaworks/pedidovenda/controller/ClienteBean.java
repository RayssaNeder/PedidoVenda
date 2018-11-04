package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.pedidovenda.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes;
	
	
	public ClienteBean() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
			clientes.add(criaCliente("Supermercado João das Couves Ltda", "Jurídica", "02.493.738/0001-83"));
			clientes.add(criaCliente("Maria Conceição da Abadia", "Física", "02.493.738/0001-83"));
			clientes.add(criaCliente("Supermercado Preço Bom Ltda", "Jurídica", "02.493.738/0001-83"));
	
	}
	
	private Cliente criaCliente(String nome, String tipoPessoa, String cpf) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setCpfCnpj(cpf);
		return cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	


}
