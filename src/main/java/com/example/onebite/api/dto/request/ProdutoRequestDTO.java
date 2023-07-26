package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.RestauranteIdRequestDTO;

public class ProdutoRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private Boolean ativo;
	
	@Valid
	@NotNull
	private RestauranteIdRequestDTO restaurante;

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

	public RestauranteIdRequestDTO getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteIdRequestDTO restaurante) {
		this.restaurante = restaurante;
	}
	
}