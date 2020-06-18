package com.algaworks.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	@NotNull
	private Date dataCriacao;
	@Column(columnDefinition = "text")
	private String observacao;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_entrega", nullable = false)
	@NotNull
	private Date dataEntrega;
	@Column(name = "valor_frete", nullable = false, precision = 10, scale = 2)
	@NotNull
	private BigDecimal valorFrete;
	@Column(name = "valor_desconto", nullable = false, precision = 10, scale = 2)
	@NotNull
	private BigDecimal valorDesconto;
	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	@NotNull
	private BigDecimal valorTotal;
	@ManyToOne
	@JoinColumn(name = "vendedor_id", nullable = false)
	@NotNull
	private Usuario vendedor;
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	@NotNull
	private Cliente cliente;
	@Embedded
	private EnderecoEntrega enderecoEntrega;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	@NotNull
	private StatusPedido statusPedido;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedido> itensPedido;
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pagamento",nullable = false, length = 20)
	@NotNull
	private FormaPagamento formaPagamento;
	

	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public BigDecimal getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public EnderecoEntrega getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
		
	
}
