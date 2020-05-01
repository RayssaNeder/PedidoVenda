package com.algaworks.pedidovenda.model;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String tipoPessoa;
	private String email;
	private String cpfCnpj;
	private String telefone;
	private Endereco endereco;
	
	public Cliente() {
		this.tipoPessoa = "Física";
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}


	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getTipoPessoa() {
		System.out.println("GET: " + tipoPessoa);
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		System.out.println("SET: " + tipoPessoa);
		this.tipoPessoa = tipoPessoa;
	}
	
	
	
}
