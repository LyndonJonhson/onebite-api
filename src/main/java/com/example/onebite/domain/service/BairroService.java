package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.onebite.domain.dto.BairroDTO;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.model.Bairro;
import com.example.onebite.domain.repository.BairroRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository repository;
	
	private static final String MSG_BAIRRO_NAO_ENCONTRADO = "Não existe um Bairro cadastrado com esse id: %d";
	
	private static final String MSG_BAIRRO_EM_USO = "Entidade com id %d não pode ser removida, pois está em uso";
	
	public List<BairroDTO> findAll() {
		List<Bairro> list = repository.findAll();
		return list.stream().map(entity -> new BairroDTO(entity)).toList();
	}
	
	public BairroDTO findById(Long id) {		
		Bairro entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_BAIRRO_NAO_ENCONTRADO, id)));
		return new BairroDTO(entity);
	}
	
	public BairroDTO insert(BairroDTO dto) {
		Bairro entity = new Bairro();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new BairroDTO(entity);
	}
	
	@Transactional
	public BairroDTO update(Long id, BairroDTO dto) {	
		try {
			Bairro entity = repository.getReferenceById(id);			
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new BairroDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_BAIRRO_NAO_ENCONTRADO, id));
		}
	}	
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(MSG_BAIRRO_NAO_ENCONTRADO, id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_BAIRRO_EM_USO, id));
		}
	}

	private void copyDtoToEntity(BairroDTO dto, Bairro entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getCidade() != null)
			entity.setCidade(dto.getCidade());
	}
	
}
