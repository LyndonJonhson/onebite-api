package com.example.onebite.api.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Integer quantidade;
	
	private BigDecimal precoUnitario;
	
	private BigDecimal precoTotal;
	
	private String observacao;
	
	private ProdutoResponseDTO produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ProdutoResponseDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoResponseDTO produto) {
		this.produto = produto;
	}
	
}
