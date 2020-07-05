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
import com.algaworks.pedidovenda.repository.GrupoRepository;
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
	private Grupo grupo;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Grupo> grupos;
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Inject
	private GrupoRepository grupoRepository;
	
	public UsuarioBean() {
		limpar();
	}
	
	public void inicializar() {
		if(FacesUtil.isNotPostBack()) {
			this.grupos = grupoRepository.buscarTodos();
		}
	}
	
	public void salvar() {
		this.usuario = cadastroUsuarioService.salvar(usuario);
		limpar();
		FacesUtil.addInfoMessage("Uauário cadastrado com sucesso");
	}
	
	
	public void adicionarGrupo() {
		if(!this.usuario.getGrupos().contains(grupo)) {
			this.usuario.getGrupos().add(this.grupo);
		}
	}
	
	public void removerGrupo() {
		this.usuario.getGrupos().remove(this.grupo);
		FacesUtil.addInfoMessage("Grupo removido com sucesso");
	}

	private void limpar() {
		this.usuario = new Usuario();
		//this.grupos = new ArrayList<>();
		this.grupo = new Grupo();
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


	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
	
	
	
	
	

	
}
