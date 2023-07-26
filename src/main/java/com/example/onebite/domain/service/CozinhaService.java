package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.CozinhaAssembler;
import com.example.onebite.api.dto.request.CozinhaRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.model.Cozinha;
import com.example.onebite.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CozinhaAssembler cozinhaAssembler;
	
	@Transactional(readOnly = true)
	public List<Cozinha> findAll() {
		return cozinhaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Cozinha findById(Long id) {
		return cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}
	
	@Transactional
	public Cozinha insert(CozinhaRequestDTO dto) {
		Cozinha entity = cozinhaAssembler.toEntity(dto);
		return cozinhaRepository.save(entity);
	}
	
	@Transactional
	public Cozinha update(Long id, CozinhaRequestDTO dto) {
		Cozinha entity = cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		cozinhaAssembler.copyToEntity(dto, entity);
		return cozinhaRepository.save(entity);
	}
	
	public void delete(Long id) {
		try {
			cozinhaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}
	
}
