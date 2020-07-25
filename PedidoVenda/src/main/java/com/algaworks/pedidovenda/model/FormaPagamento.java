package com.algaworks.pedidovenda.model;

public enum FormaPagamento {
	DINHEIRO("Dinheiro"),
	CARTAO_DEBITO("Cartão Débito"),
	CARTAO_CREDITO("Cartão Crédito"),
	CHEQUE("Cheque"),
	BOLETO_BANCARIO("Boleto Bancário"),
	DEPOSITO_BANCARIO("Deposito Bancário");
	
	private String descricao;
	
	

	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
