package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.domain.model.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(groups = Groups.InsertBairro.class)
	private Long id;
	
	@NotBlank(groups = Groups.InsertCidade.class)
	private String nome;
	
	@Valid
	@NotNull(groups = Groups.InsertCidade.class)
	private EstadoDTO estado;
	
	public CidadeDTO() {
	}

	public CidadeDTO(Long id, String nome, EstadoDTO estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
	public CidadeDTO(Cidade entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.estado = new EstadoDTO(entity.getEstado());
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

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
}
