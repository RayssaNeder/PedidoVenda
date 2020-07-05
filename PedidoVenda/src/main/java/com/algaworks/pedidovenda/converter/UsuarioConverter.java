package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.repository.ProdutosRepository;
import com.algaworks.pedidovenda.repository.UsuariosRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private UsuariosRepository usuarioRepository;
	
	
	public UsuarioConverter() {
		this.usuarioRepository = CDIServiceLocator.getBean(UsuariosRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = usuarioRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Usuario produto = (Usuario) value;
			if(produto.getId() != null) {
				return ((Usuario) value).getId().toString();
			}
			return null;
		}
		return "";
	}

}
