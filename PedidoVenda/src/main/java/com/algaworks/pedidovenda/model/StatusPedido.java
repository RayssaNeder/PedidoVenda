package com.algaworks.pedidovenda.model;

public enum StatusPedido {
	
	ORCAMENTO("orcamento"), 
	EMITIDO("Emitido"),
	CANCELADO("Cancelado");
	
	
	public String descricao;
		

	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
