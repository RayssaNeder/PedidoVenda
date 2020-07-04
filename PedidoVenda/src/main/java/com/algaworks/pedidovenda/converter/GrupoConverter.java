package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.repository.GrupoRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private GrupoRepository grupoRepository;
	
	
	public GrupoConverter() {
		this.grupoRepository = CDIServiceLocator.getBean(GrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = grupoRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Grupo grupo = (Grupo) value;
			if(grupo.getId() != null) {
				return ((Grupo) value).getId().toString();
			}
			
			return null;
		}
		return "";
	}

}
