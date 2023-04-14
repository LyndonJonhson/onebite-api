package com.example.onebite.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.dto.BairroDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Bairro;
import com.example.onebite.domain.repository.BairroRepository;
import com.example.onebite.domain.repository.CidadeRepository;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Transactional(readOnly = true)
	public List<BairroDTO> findAll() {
		List<Bairro> list = repository.findAll();
		return list.stream().map(entity -> new BairroDTO(entity)).toList();
	}
	
	@Transactional(readOnly = true)
	public BairroDTO findById(Long id) {		
		Bairro entity = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		return new BairroDTO(entity);
	}
	
	@Transactional
	public BairroDTO insert(BairroDTO dto) {
		try {
			Bairro entity = new Bairro();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new BairroDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}
		
	}
	
	@Transactional
	public BairroDTO update(Long id, BairroDTO dto) {	
		try {
			Bairro entity = repository.getReferenceById(id);			
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new BairroDTO(entity);
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

	private void copyDtoToEntity(BairroDTO dto, Bairro entity) {
		if (dto.getNome() != null)
			entity.setNome(dto.getNome());
		if (dto.getCidade() != null)
			entity.setCidade(cidadeRepository.getReferenceById(dto.getCidade().getId()));			
	}
	
}
