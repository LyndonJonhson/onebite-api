package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.domain.dto.CidadeDTO;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.Mensagem;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	@Transactional(readOnly = true)
	public List<CidadeDTO> findAll() {
		List<Cidade> list = repository.findAll();
		return list.stream().map(entity -> new CidadeDTO(entity)).toList();
	}
	
	@Transactional(readOnly = true)
	public CidadeDTO findById(Long id) {
		Cidade entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		return new CidadeDTO(entity);
	}
	
	@Transactional
	public CidadeDTO insert(CidadeDTO dto) {
		try {
			Cidade entity = new Cidade();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CidadeDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}	
	}
	
	@Transactional
	public CidadeDTO update(Long id, CidadeDTO dto) {
		try {
			Cidade entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new CidadeDTO(entity);
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
	
	private void copyDtoToEntity(CidadeDTO dto, Cidade entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getEstado() != null)
			entity.setEstado(dto.getEstado());
	}
	
}
