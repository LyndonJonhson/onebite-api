package com.example.onebite.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.domain.entity.Endereco;
import com.example.onebite.domain.entity.Restaurante;

public class RestauranteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "campo requerido")
	private String nome;
	
	@NotBlank(message = "campo requerido")
	private String telefone;
	
	@NotBlank(message = "campo requerido")
	private String descricao;
	
	@NotNull(message = "campo requerido")
	private Boolean aberto;
	
	@NotNull(message = "campo requerido")
	private Boolean ativo;
	
	private Date dataCadastro;
	
	@Valid
	@NotNull(message = "campo requerido")
	private Endereco endereco;

	public RestauranteDTO() {
	}

	public RestauranteDTO(Long id, String nome, String telefone, String descricao, Boolean aberto, Boolean ativo, Endereco endereco) {
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
		this.endereco = entity.getEndereco();
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
