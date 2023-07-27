package com.example.onebite.domain.enums;

public enum StatusPedido {
	
	CRIADO("Criado", 1),
	
	CONFIRMADO("Confirmado", 2),
	
	EM_PREPARO("Em Preparo", 3),
	
	EM_ENTREGA("Em Entrega", 4),
	
	ENTREGUE("Entregue", 5),
	
	CANCELADO("Cancelado", 6);
	
	private String mensagem;
	
	private int numero;

	private StatusPedido(String mensagem, int numero) {
		this.mensagem = mensagem;
		this.numero = numero;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getNumero() {
		return numero;
	}
	
}
