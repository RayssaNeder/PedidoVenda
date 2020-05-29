package com.algaworks.pedidovenda.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.algaworks.pedidovenda.service.NegocioException;

public class JsfEceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public JsfEceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable exception = context.getException();
			NegocioException negocioException = getNegocioException(exception);

			boolean handled = false;
			try {
				if (exception instanceof ViewExpiredException) {
					redirect("/");
					handled = true;
				} else if (negocioException != null) {
					FacesUtil.addErrorMessage(negocioException.getMessage());
					handled = true;
				}

				else {
					redirect("/Erro.xhtml");
					handled = true;
				}
			} finally {
				if (handled) {
					events.remove();
				}
			}

		}

		getWrapped().handle();

	}


	private void redirect(String page) {

		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();

			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}

	}
	
	
	private NegocioException getNegocioException(Throwable exception) {
		if (exception instanceof NegocioException) {
			return (NegocioException) exception;
		} else if (exception.getCause() != null) {
			return getNegocioException(exception.getCause());
		}
		
		return null;
	}

}
