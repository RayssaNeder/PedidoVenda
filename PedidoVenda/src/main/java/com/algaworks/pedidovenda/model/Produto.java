package com.algaworks.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.pedidovenda.controller.validation.SKU;
import com.algaworks.pedidovenda.service.NegocioException;


@Entity
public class Produto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length = 100)
	@NotBlank
	@Size(max = 10)
	private String nome;	
	@NotNull
	@NotBlank
	@Column(nullable = false, unique = true)
	@SKU
	private String sku;
	@NotNull(message = "é obrigatório")
	@Column(name="valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	@NotNull @Min(0) @Max(value = 9999, message = "tem valor muito alto")
	@Column(name = "qtde_estoque")
	private Integer qtdeEstoque;
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	//@NotNull
	private Categoria categoria;
	
	public void baixarEstoque(Integer quantidade) {
		int novaQuantidade = this.getQtdeEstoque() - quantidade;
		
		if(novaQuantidade < 0) {
			throw new NegocioException("Não há disponibilidade no estoque de " + quantidade + " itens do produdo " + this.getSku());
		}
		
		this.setQtdeEstoque(novaQuantidade);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
