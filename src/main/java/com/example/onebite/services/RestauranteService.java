package com.example.onebite.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.onebite.dto.RestauranteDTO;
import com.example.onebite.entities.Restaurante;
import com.example.onebite.repositories.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository repository;
	
	public List<RestauranteDTO> findAll() {
		List<Restaurante> list = repository.findAll();
		return list.stream().map(restaurante -> new RestauranteDTO(restaurante)).toList();
	}
	
	public RestauranteDTO findById(Long id) {
		Optional<Restaurante> obj = repository.findById(id);
		Restaurante entity = obj.orElseThrow(() -> new EntityNotFoundException());
		return new RestauranteDTO(entity);
	}
	
	public RestauranteDTO insert(RestauranteDTO dto) {
		Restaurante entity = new Restaurante();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new RestauranteDTO(entity);
	}
	
	@Transactional
	public RestauranteDTO update(Long id, RestauranteDTO dto) {
		try {
			Restaurante entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new RestauranteDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw e;
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
	
	private void copyDtoToEntity(RestauranteDTO dto, Restaurante entity) {
		if (dto.getNome() != null)			
			entity.setNome(dto.getNome());
		if (dto.getTelefone() != null)		
			entity.setTelefone(dto.getTelefone());
		if (dto.getDescricao() != null)		
			entity.setDescricao(dto.getDescricao());
		if (dto.getAberto() != null)
			entity.setAberto(dto.getAberto());
		if (dto.getAtivo() != null)
			entity.setAtivo(dto.getAtivo());
		if (dto.getEndereco() != null)
			entity.setEndereco(dto.getEndereco());
	}
	
}
