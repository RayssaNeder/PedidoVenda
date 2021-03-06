package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.ClienteRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private ClienteRepository clienteRepository;
	
	
	public ClienteConverter() {
		this.clienteRepository = CDIServiceLocator.getBean(ClienteRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = clienteRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Cliente cliente = (Cliente) value;
			if(cliente.getId() != null) {
				return ((Cliente) value).getId().toString();
			}
			return null;
		}
		return "";
	}

}
