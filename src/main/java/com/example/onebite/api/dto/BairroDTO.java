package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.example.onebite.core.validation.Groups;
import com.example.onebite.domain.model.Bairro;

public class BairroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(groups = Groups.bairro_id.class)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	@ConvertGroup(to = Groups.cidade_id.class)
	private CidadeDTO cidade;
	
	public BairroDTO() {
	}

	public BairroDTO(Long id, String nome, CidadeDTO cidade) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
	}
	
	public BairroDTO(Bairro entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cidade = new CidadeDTO(entity.getCidade());
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

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	
}
