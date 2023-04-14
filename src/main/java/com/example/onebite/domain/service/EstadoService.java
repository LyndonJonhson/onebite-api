package com.example.onebite.domain.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.onebite.domain.dto.EstadoDTO;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.model.Estado;
import com.example.onebite.domain.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repository;
	
	public List<EstadoDTO> findAll() {
		List<Estado> list = repository.findAll();
		return list.stream().map(entity -> new EstadoDTO(entity)).toList();
	}
	
	public EstadoDTO findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		Estado entity = obj.orElseThrow(() -> new EntityNotFoundException());
		return new EstadoDTO(entity);
	}
	
	public EstadoDTO insert(EstadoDTO dto) {
		Estado entity = new Estado();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EstadoDTO(entity);
	}
	
	@Transactional
	public EstadoDTO update(Long id, EstadoDTO dto) {
		try {
			Estado entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EstadoDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException("Entidade não encontrada");
		}
		catch (DataIntegrityViolationException e) {
			throw e;
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw e;
		}
	}

	private void copyDtoToEntity(EstadoDTO dto, Estado entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getSigla() != null)
			entity.setSigla(dto.getSigla());
	}
	
}
