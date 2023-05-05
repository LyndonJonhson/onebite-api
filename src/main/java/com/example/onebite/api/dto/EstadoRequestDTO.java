package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class EstadoRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;

	@NotBlank
	private String sigla;

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
