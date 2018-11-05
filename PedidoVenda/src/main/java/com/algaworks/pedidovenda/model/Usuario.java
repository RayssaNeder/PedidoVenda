 package com.algaworks.pedidovenda.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 2764326939546393402L;
	private String nome;
	private String email;
	private String senha;
	private Grupo grupo; 
	
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	
	
	
	
}
