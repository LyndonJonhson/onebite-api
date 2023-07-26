package com.example.onebite.api.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;

	private String descricao;
	
	private BigDecimal preco;
	
	private Boolean ativo;
	
	private RestauranteResponseDTO restaurante;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public RestauranteResponseDTO getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteResponseDTO restaurante) {
		this.restaurante = restaurante;
	}
	
}