package com.example.onebite.api.dto;

import java.io.Serializable;
import java.util.Date;

public class RestauranteResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String telefone;

	private String descricao;

	private Boolean aberto;

	private Boolean ativo;

	private Date dataCadastro;

	private EnderecoResponseDTO endereco;

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

	public EnderecoResponseDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResponseDTO endereco) {
		this.endereco = endereco;
	}

}
