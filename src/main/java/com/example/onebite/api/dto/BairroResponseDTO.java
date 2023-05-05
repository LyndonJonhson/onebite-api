package com.example.onebite.api.dto;

import java.io.Serializable;

import com.example.onebite.domain.model.Bairro;

public class BairroResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private CidadeResponseDTO cidade;

	public BairroResponseDTO() {
	}

	public BairroResponseDTO(Long id, String nome, CidadeResponseDTO cidade) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
	}

	public BairroResponseDTO(Bairro entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cidade = new CidadeResponseDTO(entity.getCidade());
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

	public CidadeResponseDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeResponseDTO cidade) {
		this.cidade = cidade;
	}

}
