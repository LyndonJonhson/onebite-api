package com.example.onebite.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.domain.model.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long id;
	
	@NotBlank(groups = Groups.InsertRestaurante.class)
	private String nome;
	
	@NotBlank(groups = Groups.InsertRestaurante.class)
	private String telefone;
	
	private String descricao;
	
	@NotNull(groups = Groups.InsertRestaurante.class)
	private Boolean aberto;
	
	@NotNull(groups = Groups.InsertRestaurante.class)
	private Boolean ativo;
	
	private Date dataCadastro;
	
	@Valid
	@NotNull(groups = Groups.InsertRestaurante.class)
	private EnderecoDTO endereco;

	public RestauranteDTO() {
	}

	public RestauranteDTO(Long id, String nome, String telefone, String descricao, Boolean aberto, Boolean ativo, EnderecoDTO endereco) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.descricao = descricao;
		this.aberto = aberto;
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	public RestauranteDTO(Restaurante entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.telefone = entity.getTelefone();
		this.descricao = entity.getDescricao();
		this.dataCadastro = entity.getDataCadastro();
		this.aberto = entity.getAberto();
		this.ativo = entity.getAtivo();
		this.endereco = new EnderecoDTO(entity.getEndereco());
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
	
	public Boolean getAberto() {
		return aberto;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
}
