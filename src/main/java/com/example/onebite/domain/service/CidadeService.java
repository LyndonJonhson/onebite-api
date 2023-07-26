package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.CidadeAssembler;
import com.example.onebite.api.dto.request.CidadeRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CidadeAssembler cidadeAssembler;

	@Transactional(readOnly = true)
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Cidade findById(Long id) {
		return cidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public Cidade insert(CidadeRequestDTO dto) {
		try {
			Cidade entity = cidadeAssembler.toEntity(dto);
			return cidadeRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}
	}

	@Transactional
	public Cidade update(Long id, CidadeRequestDTO dto) {
		Cidade entity = cidadeRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		cidadeAssembler.copyToEntity(dto, entity);
		return cidadeRepository.save(entity);

	}

	public void delete(Long id) {
		try {
			cidadeRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}