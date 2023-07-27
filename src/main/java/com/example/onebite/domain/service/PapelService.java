package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.PapelAssembler;
import com.example.onebite.api.dto.request.PapelRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Papel;
import com.example.onebite.domain.repository.PapelRepository;

@Service
public class PapelService {

	@Autowired
	private PapelRepository papelRepository;

	@Autowired
	private PapelAssembler papelAssembler;

	@Transactional(readOnly = true)
	public List<Papel> findAll() {
		return papelRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Papel findById(Long id) {
		return papelRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public Papel insert(PapelRequestDTO dto) {
		try {
			Papel entity = papelAssembler.toEntity(dto);
			return papelRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}

	}

	@Transactional
	public Papel update(Long id, PapelRequestDTO dto) {
		Papel entity = papelRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		papelAssembler.copyToEntity(dto, entity);
		return papelRepository.save(entity);

	}

	public void delete(Long id) {
		try {
			papelRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}
