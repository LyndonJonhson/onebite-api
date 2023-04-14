package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.dto.EstadoDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Estado;
import com.example.onebite.domain.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	@Transactional(readOnly = true)
	public List<EstadoDTO> findAll() {
		List<Estado> list = repository.findAll();
		return list.stream().map(entity -> new EstadoDTO(entity)).toList();
	}
	
	@Transactional(readOnly = true)
	public EstadoDTO findById(Long id) {
		Estado entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		return new EstadoDTO(entity);
	}
	
	@Transactional
	public EstadoDTO insert(EstadoDTO dto) {
		try {
			Estado entity = new Estado();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EstadoDTO(entity);			
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}
	}
	
	@Transactional
	public EstadoDTO update(Long id, EstadoDTO dto) {
		try {
			Estado entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EstadoDTO(entity);
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

	private void copyDtoToEntity(EstadoDTO dto, Estado entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getSigla() != null)
			entity.setSigla(dto.getSigla());
	}
	
}
