package com.example.onebite.api.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.example.onebite.core.validation.Groups;
import com.example.onebite.domain.model.Endereco;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String cep;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	private String complemento;
	
	@Valid	
	@NotNull
	@ConvertGroup(to = Groups.bairro_id.class)
	private BairroResponseDTO bairro;

	public EnderecoDTO() {
	}

	public EnderecoDTO(String cep, String logradouro, String numero, String complemento, BairroResponseDTO bairro) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}
	
	public EnderecoDTO(Endereco entity) {
		this.cep = entity.getCep();
		this.logradouro = entity.getLogradouro();
		this.numero = entity.getNumero();
		this.complemento = entity.getComplemento();
		this.bairro = new BairroResponseDTO(entity.getBairro());
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public BairroResponseDTO getBairro() {
		return bairro;
	}

	public void setBairro(BairroResponseDTO bairro) {
		this.bairro = bairro;
	}
	
}
