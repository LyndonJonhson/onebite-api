package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.ProdutoIdRequestDTO;

public class ItemPedidoRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Integer quantidade;
	
	@NotNull
	private BigDecimal precoUnitario;
		
	private String observacao;
	
	@Valid
	@NotNull
	private ProdutoIdRequestDTO produto;
	
	private PedidoRequestDTO pedido;

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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ProdutoIdRequestDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoIdRequestDTO produto) {
		this.produto = produto;
	}

	public PedidoRequestDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoRequestDTO pedido) {
		this.pedido = pedido;
	}
	
}