package com.example.onebite.api.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UsuarioRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}