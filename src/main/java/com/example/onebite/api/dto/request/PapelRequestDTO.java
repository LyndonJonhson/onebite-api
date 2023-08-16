package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PapelRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@NotEmpty
	private Set<PermissaoRequestDTO> permissoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<PermissaoRequestDTO> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<PermissaoRequestDTO> permissoes) {
		this.permissoes = permissoes;
	}

}