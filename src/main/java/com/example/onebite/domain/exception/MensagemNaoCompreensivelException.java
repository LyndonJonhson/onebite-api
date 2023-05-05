package com.example.onebite.domain.exception;

public class MensagemNaoCompreensivelException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MensagemNaoCompreensivelException(String msg) {
		super(msg);
	}

}
