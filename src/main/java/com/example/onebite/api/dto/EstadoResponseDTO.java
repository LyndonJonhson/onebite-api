package com.example.onebite.api.dto;

import java.io.Serializable;

import com.example.onebite.domain.model.Estado;

public class EstadoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;

	private String sigla;
	
	public EstadoResponseDTO() {
	}

	public EstadoResponseDTO(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public EstadoResponseDTO(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.sigla = entity.getSigla();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
