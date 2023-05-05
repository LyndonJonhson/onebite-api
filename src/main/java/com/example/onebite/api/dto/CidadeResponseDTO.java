package com.example.onebite.api.dto;

import java.io.Serializable;

import com.example.onebite.domain.model.Cidade;

public class CidadeResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nome;

	private EstadoResponseDTO estado;
	
	public CidadeResponseDTO() {
	}

	public CidadeResponseDTO(Long id, String nome, EstadoResponseDTO estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
	public CidadeResponseDTO(Cidade entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.estado = new EstadoResponseDTO(entity.getEstado());
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

	public EstadoResponseDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoResponseDTO estado) {
		this.estado = estado;
	}
	
}
