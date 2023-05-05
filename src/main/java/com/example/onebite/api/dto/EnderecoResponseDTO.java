package com.example.onebite.api.dto;

import java.io.Serializable;

import com.example.onebite.domain.model.Endereco;

public class EnderecoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private BairroResponseDTO bairro;

	public EnderecoResponseDTO() {
	}

	public EnderecoResponseDTO(String cep, String logradouro, String numero, String complemento,
			BairroResponseDTO bairro) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public EnderecoResponseDTO(Endereco entity) {
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
