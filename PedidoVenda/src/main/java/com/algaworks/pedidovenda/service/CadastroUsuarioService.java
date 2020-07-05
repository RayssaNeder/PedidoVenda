package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.UsuariosRepository;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroUsuarioService implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuariosRepository usuarioRepository;
	
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.porEmail(usuario.getEmail());
		if(usuarioExistente != null && !usuarioExistente.equals(usuario)) {
			throw new NegocioException("Já exste um usuário cadastrao para o email informado");
		}
		return usuarioRepository.salvar(usuario);
		
	}

}
