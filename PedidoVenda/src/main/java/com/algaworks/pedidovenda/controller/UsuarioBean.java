package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.inject.Named;

//import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Grupo> grupos;
	private List<Grupo> gruposDoUsuario;
	
	public UsuarioBean() {

		usuarios = new ArrayList<Usuario>();
		usuarios.add(criaUsuario("João das Couves Ltda", "joaodas_couves42@hotmail.com"));
		usuarios.add(criaUsuario("Maria Abadia das Couves", "mariaabadiadascouves2013@gmail.com"));
		usuarios.add(criaUsuario("João das Couves Júnior", "junior_couves_joao@yahoo.com.br"));
		
	//	this.grupos = Arrays.asList(Grupo.values());
		this.gruposDoUsuario = setaGruposDoUsuario();
	
	}
	
	private List<Grupo> setaGruposDoUsuario() {
		 List<Grupo> gruposDoUsuario = new ArrayList<Grupo>() ;	
		gruposDoUsuario.add(Grupo.ADMINISTRADOR);
		gruposDoUsuario.add(Grupo.AUXILIAR);
		return gruposDoUsuario;
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

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public void setGruposDoUsuario(List<Grupo> gruposDoUsuario) {
		this.gruposDoUsuario = gruposDoUsuario;
	}

	public List<Grupo> getGruposDoUsuario() {
		return gruposDoUsuario;
	}
	
	
	
	
	
	

	
}
