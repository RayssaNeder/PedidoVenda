package com.algaworks.pedidovenda.model;

public enum TipoPessoa {
	
	FISICA("Física"), JURIDICA("Jurídica");
	
	private String tipoPessoa;
	
	

	private TipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	

}
