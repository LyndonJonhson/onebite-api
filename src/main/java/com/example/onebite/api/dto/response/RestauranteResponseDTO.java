package com.example.onebite.api.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.onebite.domain.model.FormaPagamento;
import com.example.onebite.domain.model.Produto;
import com.example.onebite.domain.model.Usuario;

public class RestauranteResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String telefone;

	private String descricao;

	private Boolean aberto;

	private Boolean ativo;

	private Date dataCadastro;
	
	private CozinhaResponseDTO cozinha;
	
	private List<Usuario> responsaveis = new ArrayList<>();
	
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
	
	private List<Produto> produtos = new ArrayList<>();

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
	
	public CozinhaResponseDTO getCozinha() {
		return cozinha;
	}

	public void setCozinha(CozinhaResponseDTO cozinha) {
		this.cozinha = cozinha;
	}

	public List<Usuario> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Usuario> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public EnderecoResponseDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResponseDTO endereco) {
		this.endereco = endereco;
	}

}
