package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PapelRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@NotEmpty
	private List<PermissaoRequestDTO> permissoes = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PermissaoRequestDTO> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoRequestDTO> permissoes) {
		this.permissoes = permissoes;
	}

}