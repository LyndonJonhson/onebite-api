package com.example.onebite.api.dto;

import java.io.Serializable;

import com.example.onebite.domain.entity.Bairro;
import com.example.onebite.domain.entity.Cidade;

public class BairroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private Cidade cidade;
	
	public BairroDTO() {
	}

	public BairroDTO(Long id, String nome, Cidade cidade) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
	}
	
	public BairroDTO(Bairro entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cidade = entity.getCidade();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
