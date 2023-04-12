package com.example.onebite.dto;

import java.io.Serializable;

import com.example.onebite.entities.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String telefone;
	
	private String descricao;

	public RestauranteDTO() {
	}

	public RestauranteDTO(Long id, String name, String telefone, String descricao) {
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.descricao = descricao;
	}
	
	public RestauranteDTO(Restaurante entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.telefone = entity.getTelefone();
		this.descricao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
