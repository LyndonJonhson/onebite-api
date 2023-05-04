package com.example.onebite.api.dto.input;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CidadeInputDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	private EstadoIdInputDTO estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoIdInputDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoIdInputDTO estado) {
		this.estado = estado;
	}
	
}