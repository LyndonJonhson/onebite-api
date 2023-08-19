package com.example.onebite.api.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PapelResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private List<PermissaoResponseDTO> permissoes = new ArrayList<>();

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

	public List<PermissaoResponseDTO> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoResponseDTO> permissoes) {
		this.permissoes = permissoes;
	}
	
}
