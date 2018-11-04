package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Endereco> enderecos;
	
	
	public ClienteBean() {
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
			clientes.add(criaCliente("Supermercado João das Couves Ltda", "Jurídica", "02.493.738/0001-83"));
			clientes.add(criaCliente("Maria Conceição da Abadia", "Física", "02.493.738/0001-83"));
			clientes.add(criaCliente("Supermercado Preço Bom Ltda", "Jurídica", "02.493.738/0001-83"));
			
			enderecos = new ArrayList<Endereco>();
			enderecos.add(criaEndereco("Rua das Pedras Grandes Azuis", "1234", "Ap. 1022", "38499-533", "Uberlandia/MG"));
			enderecos.add(criaEndereco("Av. Randon Pacheco", "455", "Sala 923", "38408-111", "Uberlandia/MG"));
	
	}
	
	private Endereco criaEndereco(String logradouro, String numero, String complemento, String cep, String cidadeUF) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);
		endereco.setCidadeUF(cidadeUF);
		return endereco;
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	
	
	


}
