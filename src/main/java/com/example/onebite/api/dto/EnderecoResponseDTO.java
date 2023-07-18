package com.example.onebite.api.dto;

import java.io.Serializable;

public class EnderecoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private BairroResponseDTO bairro;

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
