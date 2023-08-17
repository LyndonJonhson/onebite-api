package com.example.onebite.api.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.onebite.api.dto.request.id.FormaPagamentoIdRequestDTO;
import com.example.onebite.api.dto.request.id.ItemPedidoIdRequestDTO;
import com.example.onebite.api.dto.request.id.RestauranteIdRequestDTO;
import com.example.onebite.api.dto.request.id.UsuarioIdRequestDTO;
import com.example.onebite.domain.enums.StatusPedido;

public class PedidoRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigDecimal subTotal;
	
	private BigDecimal taxaFrete;
	
	private BigDecimal valorTotal;
	
	private Date dataCriacao;
	
	private Date dataConfirmacao;
	
	private Date dataEmPreparacao;
	
	private Date dataEmEntrega;
	
	private Date dataEntrega;
	
	private Date dataCancelamento;
	
	@NotNull
	private StatusPedido status;
	
	private Set<ItemPedidoIdRequestDTO> itens = new HashSet<>();
	
	@NotNull
	private UsuarioIdRequestDTO cliente;
	
	@NotNull
	private RestauranteIdRequestDTO restaurante;
	
	@NotNull
	private FormaPagamentoIdRequestDTO formaPagamento;
	
	@Valid
	@NotNull
	private EnderecoRequestDTO enderecoEntrega;

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(Date dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public Date getDataEmPreparacao() {
		return dataEmPreparacao;
	}

	public void setDataEmPreparacao(Date dataEmPreparacao) {
		this.dataEmPreparacao = dataEmPreparacao;
	}

	public Date getDataEmEntrega() {
		return dataEmEntrega;
	}

	public void setDataEmEntrega(Date dataEmEntrega) {
		this.dataEmEntrega = dataEmEntrega;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Set<ItemPedidoIdRequestDTO> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedidoIdRequestDTO> itens) {
		this.itens = itens;
	}

	public UsuarioIdRequestDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioIdRequestDTO cliente) {
		this.cliente = cliente;
	}

	public RestauranteIdRequestDTO getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteIdRequestDTO restaurante) {
		this.restaurante = restaurante;
	}

	public FormaPagamentoIdRequestDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoIdRequestDTO formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnderecoRequestDTO getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoRequestDTO enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
}