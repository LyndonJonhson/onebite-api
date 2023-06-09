package com.example.onebite.api.exceptionhandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;

@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<StandardError> entidadeNaoEncontradaExceptionHandler(EntidadeNaoEncontradaException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Entidade não encontrada");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<StandardError> entidadeEmUsoExceptionHandler(EntidadeEmUsoException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Entidade em uso");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MensagemNaoCompreensivelException.class)
	public ResponseEntity<StandardError> MensagemNaoCompreensivelExceptionHandler(MensagemNaoCompreensivelException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Mensagem não legível");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardError> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Mensagem não legível");
		err.setMessage(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<StandardError> httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Tipo de mídia não aceito");
		err.setMessage("O tipo de mídia solicitado na requisição não é aceito");
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Erro de validação");
		err.setMessage(Mensagem.ERRO_DE_VALIDACAO.getMensagem());
		err.setPath(request.getRequestURI());

		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			err.addError(fieldError.getField(), message);
		}

		return ResponseEntity.status(status).body(err);
	}

}
