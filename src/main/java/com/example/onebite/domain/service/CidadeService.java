package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.CidadeAssembler;
import com.example.onebite.api.dto.input.CidadeInputDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private CidadeAssembler cidadeAssembler;
	
	@Transactional(readOnly = true)
	public List<Cidade> findAll() {
		List<Cidade> list = repository.findAll();
		return list;
	}
	
	@Transactional(readOnly = true)
	public Cidade findById(Long id) {
		Cidade entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		return entity;
	}
	
	@Transactional
	public Cidade insert(CidadeInputDTO dto) {
		try {
			Cidade entity = cidadeAssembler.toEntity(dto);
			return repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}	
	}
	
	@Transactional
	public Cidade update(Long id, CidadeInputDTO dto) {
		try {
			Cidade entity = repository.getReferenceById(id);
			cidadeAssembler.copyToEntity(dto, entity);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}
	
}