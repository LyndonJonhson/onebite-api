package com.example.onebite.api.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.onebite.domain.enums.StatusPedido;

public class PedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	
	private BigDecimal subTotal;
	
	private BigDecimal taxaFrete;
	
	private BigDecimal valorTotal;
	
	private Date dataCriacao;
	
	private Date dataConfirmacao;
	
	private Date dataEmPreparacao;
	
	private Date dataEmEntrega;
	
	private Date dataEntrega;
	
	private Date dataCancelamento;
	
	private StatusPedido status;
	
	private List<ItemPedidoResponseDTO> itens = new ArrayList<>();
	
	private UsuarioResponseDTO cliente;
	
	private RestauranteResponseDTO restaurante;
	
	private FormaPagamentoResponseDTO formaPagamento;

	private EnderecoResponseDTO enderecoEntrega;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	public List<ItemPedidoResponseDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoResponseDTO> itens) {
		this.itens = itens;
	}

	public UsuarioResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioResponseDTO cliente) {
		this.cliente = cliente;
	}

	public RestauranteResponseDTO getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteResponseDTO restaurante) {
		this.restaurante = restaurante;
	}

	public FormaPagamentoResponseDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoResponseDTO formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnderecoResponseDTO getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoResponseDTO enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

}
