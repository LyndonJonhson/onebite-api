package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.BairroAssembler;
import com.example.onebite.api.dto.BairroRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Bairro;
import com.example.onebite.domain.repository.BairroRepository;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private BairroAssembler bairroAssembler;

	@Transactional(readOnly = true)
	public List<Bairro> findAll() {
		return bairroRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Bairro findById(Long id) {
		return bairroRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public Bairro insert(BairroRequestDTO dto) {
		try {
			Bairro entity = bairroAssembler.toEntity(dto);
			return bairroRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}

	}

	@Transactional
	public Bairro update(Long id, BairroRequestDTO dto) {
		Bairro entity = bairroRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		bairroAssembler.copyToEntity(dto, entity);
		return bairroRepository.save(entity);

	}

	public void delete(Long id) {
		try {
			bairroRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}
