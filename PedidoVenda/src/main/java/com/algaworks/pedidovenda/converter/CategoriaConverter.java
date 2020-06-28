package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private CategoriasRepository categoriaRepository;
	
	
	public CategoriaConverter() {
		this.categoriaRepository = CDIServiceLocator.getBean(CategoriasRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = categoriaRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Categoria) value).getId().toString();
		}
		return "";
	}

}
