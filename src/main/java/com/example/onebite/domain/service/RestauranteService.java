package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.dto.RestauranteDTO;
import com.example.onebite.domain.entity.Restaurante;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.Mensagem;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository repository;
	
	@Transactional(readOnly = true)
	public List<RestauranteDTO> findAll() {
		List<Restaurante> list = repository.findAll();
		return list.stream().map(entity -> new RestauranteDTO(entity)).toList();
	}
	
	@Transactional(readOnly = true)
	public RestauranteDTO findById(Long id) {
		Restaurante entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		return new RestauranteDTO(entity);
	}
	
	@Transactional
	public RestauranteDTO insert(RestauranteDTO dto) {
		try {
			Restaurante entity = new Restaurante();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new RestauranteDTO(entity);			
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}
	}
	
	@Transactional
	public RestauranteDTO update(Long id, RestauranteDTO dto) {
		try {
			Restaurante entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new RestauranteDTO(entity);
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
		if (dto.getEndereco() != null) {
			if (dto.getEndereco().getCep() != null)
				entity.getEndereco().setCep(dto.getEndereco().getCep());
			if (dto.getEndereco().getLogradouro() != null)
				entity.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());
			if (dto.getEndereco().getNumero() != null)
				entity.getEndereco().setNumero(dto.getEndereco().getNumero());
			if (dto.getEndereco().getComplemento() != null)
				entity.getEndereco().setComplemento(dto.getEndereco().getComplemento());
			if (dto.getEndereco().getBairro() != null)
				entity.getEndereco().setBairro(dto.getEndereco().getBairro());
		}
	}
	
}
