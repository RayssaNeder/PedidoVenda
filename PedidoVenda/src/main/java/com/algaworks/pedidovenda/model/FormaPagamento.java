package com.algaworks.pedidovenda.model;

public enum FormaPagamento {
	DINHEIRO("Dinheiro"),
	CARTAO_DEBITO("Cartão Débito"),
	CARTAO_CREDITO("Cartão Crédito"),
	CHEQUE("Cheque"),
	BOLETO_BANCARIO("Boleto Bancário"),
	DEPOSITO_BANCARIO("Deposito Bancário");
	
	private String descrição;
	
	

	private FormaPagamento(String descrição) {
		this.descrição = descrição;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	
	

}
