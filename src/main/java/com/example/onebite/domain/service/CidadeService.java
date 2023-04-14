package com.example.onebite.domain.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.onebite.domain.dto.CidadeDTO;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<CidadeDTO> findAll() {
		List<Cidade> list = repository.findAll();
		return list.stream().map(entity -> new CidadeDTO(entity)).toList();
	}
	
	public CidadeDTO findById(Long id) {
		Optional<Cidade> obj = repository.findById(id);
		Cidade entity = obj.orElseThrow(() -> new EntityNotFoundException());
		return new CidadeDTO(entity);
	}
	
	public CidadeDTO insert(CidadeDTO dto) {
		Cidade entity = new Cidade();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CidadeDTO(entity);
	}
	
	@Transactional
	public CidadeDTO update(Long id, CidadeDTO dto) {
		try {
			Cidade entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CidadeDTO(entity);
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

	private void copyDtoToEntity(CidadeDTO dto, Cidade entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getEstado() != null)
			entity.setEstado(dto.getEstado());
	}
	
}
