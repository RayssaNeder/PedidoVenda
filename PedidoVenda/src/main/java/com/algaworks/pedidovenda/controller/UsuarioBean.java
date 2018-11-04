package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -594794188067693016L;
	private Usuario usuario;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioBean() {

		usuarios = new ArrayList<Usuario>();
		usuarios.add(criaUsuario("João das Couves Ltda", "joaodas_couves42@hotmail.com"));
		usuarios.add(criaUsuario("Maria Abadia das Couves", "mariaabadiadascouves2013@gmail.com"));
		usuarios.add(criaUsuario("João das Couves Júnior", "junior_couves_joao@yahoo.com.br"));
	
	}
	
	private Usuario criaUsuario(String nome, String email) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		return usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
}
