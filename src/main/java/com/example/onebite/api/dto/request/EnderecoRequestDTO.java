package com.example.onebite.api.dto.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.BairroIdRequestDTO;

public class EnderecoRequestDTO implements Serializable {
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
	private BairroIdRequestDTO bairro;

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

	public BairroIdRequestDTO getBairro() {
		return bairro;
	}

	public void setBairro(BairroIdRequestDTO bairro) {
		this.bairro = bairro;
	}

}
