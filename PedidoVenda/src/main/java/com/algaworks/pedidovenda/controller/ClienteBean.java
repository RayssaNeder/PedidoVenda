package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped; //View do CDI
//import javax.faces.bean.ViewScoped; //View do JFF
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;

@Named
@ViewScoped
public class ClienteBean implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	
	public ClienteBean() {
		
		this.cliente = criaCliente("Rayssa", TipoPessoa.FISICA, "08044101423");
		this.endereco = criaEndereco("Rua itarema", "12", "casaA", "58059122", "joão Pessoa", "PE");
		
		this.enderecos.add(endereco);
		this.cliente.setEnderecos(enderecos);
		this.clientes.add(cliente);
		
	
	}
	
	private Endereco criaEndereco(String logradouro, String numero, String complemento, String cep, String cidade, String uf) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		return endereco;
	}

	private Cliente criaCliente(String nome, TipoPessoa tipoPessoa, String cpf) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setDocumentoReceitaFederal(cpf);
		return cliente;
	}
	
	public void removeCliente() {	
				
			// Implementação da funcionalidade de remoção aqui
		
			FacesContext context =  FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente removido com sucesso", "Cliente removido com sucesso");

			context.addMessage("exclusaoSucesso", msg);
		
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
	
	
	
	


}
