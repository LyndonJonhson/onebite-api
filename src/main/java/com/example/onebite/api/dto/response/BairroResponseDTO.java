package com.example.onebite.api.dto.response;

import java.io.Serializable;

public class BairroResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private CidadeResponseDTO cidade;

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

	public CidadeResponseDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeResponseDTO cidade) {
		this.cidade = cidade;
	}

}
