package com.example.onebite.domain.exception;

public enum Mensagem {
	
	ENTIDADE_NAO_ENCONTRADA("Não existe uma entidade cadastrada com esse id: %d"),
	
	ENTIDADE_EM_USO("Entidade com id %d não pode ser removida, pois está em uso"),
	
	MENSAGEM_NAO_COMPREENSIVEL("Corpo da requisição com algum campo ou dado errado");
	
	private String mensagem;
	
	Mensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
