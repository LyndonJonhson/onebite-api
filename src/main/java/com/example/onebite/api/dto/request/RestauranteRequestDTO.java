package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.CozinhaIdRequestDTO;

public class RestauranteRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;

	private String descricao;

	@NotNull
	private Boolean aberto;

	@NotNull
	private Boolean ativo;

	private Date dataCadastro;
	
	@Valid
	@NotNull
	private CozinhaIdRequestDTO cozinha;

	@Valid
	@NotNull
	private EnderecoRequestDTO endereco;

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

	public EnderecoRequestDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequestDTO endereco) {
		this.endereco = endereco;
	}

}
