package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriasRepository;
import com.algaworks.pedidovenda.repository.ProdutosRepository;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
	
	
	//@Inject -- injeção de dependência não funciona em converters
	private ProdutosRepository produtoRepository;
	
	
	public ProdutoConverter() {
		this.produtoRepository = CDIServiceLocator.getBean(ProdutosRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;
		
		if(value != null) {
			Long id =  new Long(value);
			retorno = produtoRepository.porId(id);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Produto produto = (Produto) value;
			if(produto.getId() != null) {
				return ((Produto) value).getId().toString();
			}
			return null;
		}
		return "";
	}

}
