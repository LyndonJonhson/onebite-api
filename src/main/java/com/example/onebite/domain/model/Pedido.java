package com.example.onebite.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.example.onebite.domain.enums.StatusPedido;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String codigo;
	
	@Column(nullable = false)
	private BigDecimal subTotal;
	
	@Column(nullable = false)
	private BigDecimal taxaFrete;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private Date dataCriacao;
	
	private Date dataConfirmacao;
	
	private Date dataEmPreparacao;
	
	private Date dataEmEntrega;
	
	private Date dataEntrega;
	
	private Date dataCancelamento;
	
	@Column(nullable = false)
	private StatusPedido status;
	
	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	
	@ManyToOne
	private FormaPagamento formaPagamento;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "cep", column = @Column(name = "endereco_cep")),
		@AttributeOverride(name = "logradouro", column = @Column(name = "endereco_logradouro")),
		@AttributeOverride(name = "numero", column = @Column(name = "endereco_numero")),
		@AttributeOverride(name = "complemento", column = @Column(name = "endereco_complemento"))
	})
	private Endereco enderecoEntrega;

	public Pedido() {
	}

	public Pedido(Long id, String codigo, BigDecimal subTotal, BigDecimal taxaFrete, BigDecimal valorTotal,
			Date dataCriacao, Date dataConfirmacao, Date dataEmPreparacao, Date dataEmEntrega, Date dataEntrega,
			Date dataCancelamento, StatusPedido status, Set<ItemPedido> itens, Usuario cliente, Restaurante restaurante,
			FormaPagamento formaPagamento, Endereco enderecoEntrega) {
		this.id = id;
		this.codigo = codigo;
		this.subTotal = subTotal;
		this.taxaFrete = taxaFrete;
		this.valorTotal = valorTotal;
		this.dataCriacao = dataCriacao;
		this.dataConfirmacao = dataConfirmacao;
		this.dataEmPreparacao = dataEmPreparacao;
		this.dataEmEntrega = dataEmEntrega;
		this.dataEntrega = dataEntrega;
		this.dataCancelamento = dataCancelamento;
		this.status = status;
		this.itens = itens;
		this.cliente = cliente;
		this.restaurante = restaurante;
		this.formaPagamento = formaPagamento;
		this.enderecoEntrega = enderecoEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
}
