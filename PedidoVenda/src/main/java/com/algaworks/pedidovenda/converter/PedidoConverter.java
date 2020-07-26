package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.PedidosRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private PedidosRepository pedidoRepository;
	
	
	public PedidoConverter() {
		this.pedidoRepository = CDIServiceLocator.getBean(PedidosRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pedido retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = pedidoRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Pedido pedido = (Pedido) value;
			if(pedido.getId() != null) {
				return ((Pedido) value).getId().toString();
			}
			return null;
		}
		return "";
	}

}
