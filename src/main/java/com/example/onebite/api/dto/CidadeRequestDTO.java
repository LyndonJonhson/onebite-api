package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CidadeRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private EstadoIdRequestDTO estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoIdRequestDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoIdRequestDTO estado) {
		this.estado = estado;
	}
	
}