package com.example.onebite.api.dto.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.CidadeIdRequestDTO;

public class BairroRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@Valid
	@NotNull
	private CidadeIdRequestDTO cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CidadeIdRequestDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeIdRequestDTO cidade) {
		this.cidade = cidade;
	}

}