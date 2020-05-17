package com.algaworks.pedidovenda.util.jsf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class JsfExceptionHandleFactory extends ExceptionHandlerFactory {
	
	private ExceptionHandlerFactory parent;
	
	public JsfExceptionHandleFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfEceptionHandler(parent.getExceptionHandler());
	}

}
