package com.example.onebite.api.dto;

import java.io.Serializable;

public class CidadeResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private EstadoResponseDTO estado;

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

	public EstadoResponseDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoResponseDTO estado) {
		this.estado = estado;
	}

}
