package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.domain.model.Estado;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(groups = Groups.InsertCidade.class)
	private Long id;
	
	@NotBlank(groups = Groups.InsertEstado.class)
	private String nome;

	@NotBlank(groups = Groups.InsertEstado.class)
	private String sigla;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public EstadoDTO(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.sigla = entity.getSigla();
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
}
