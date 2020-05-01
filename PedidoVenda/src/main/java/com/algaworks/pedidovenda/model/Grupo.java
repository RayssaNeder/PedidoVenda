package com.algaworks.pedidovenda.model;

public enum Grupo {
	ADMINISTRADOR("Admnistrador"), 
	VENDEDOR("Vendedor"),
	AUXILIAR("Auxiliar");
	
	private String descricao;
	
	
	Grupo(String descricao){
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	
	
	

}
