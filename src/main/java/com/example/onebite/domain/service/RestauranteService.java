package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.RestauranteAssembler;
import com.example.onebite.api.dto.RestauranteRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Restaurante;
import com.example.onebite.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private RestauranteAssembler restauranteAssembler;

	@Transactional(readOnly = true)
	public List<Restaurante> findAll() {
		return restauranteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Restaurante findById(Long id) {
		return restauranteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public Restaurante insert(RestauranteRequestDTO dto) {
		try {
			Restaurante entity = restauranteAssembler.toEntity(dto);
			return restauranteRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}
	}

	@Transactional
	public Restaurante update(Long id, RestauranteRequestDTO dto) {
		Restaurante entity = restauranteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		restauranteAssembler.copyToEntity(dto, entity);
		return restauranteRepository.save(entity);
	}

	public void delete(Long id) {
		try {
			restauranteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}
