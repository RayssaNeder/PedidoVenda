package com.algaworks.pedidovenda.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.Transient;

//import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.service.CadastroUsuarioService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Grupo grupo = new Grupo();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Grupo> gruposDoUsuario;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	public UsuarioBean() {
		limpar();
	}
	
	public void salvar() {
		this.usuario = cadastroUsuarioService.salvar(usuario);
		limpar();
		FacesUtil.addInfoMessage("Uauário cadastrado com sucesso");
	}
	

	private void limpar() {
		this.usuario = new Usuario();
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


	public void setGruposDoUsuario(List<Grupo> gruposDoUsuario) {
		this.gruposDoUsuario = gruposDoUsuario;
	}

	public List<Grupo> getGruposDoUsuario() {
		return gruposDoUsuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	
	
	

	
}
