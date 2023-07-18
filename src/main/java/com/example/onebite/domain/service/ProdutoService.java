package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.ProdutoAssembler;
import com.example.onebite.api.dto.ProdutoRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Produto;
import com.example.onebite.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoAssembler produtoAssembler;

	@Transactional(readOnly = true)
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Produto findById(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public Produto insert(ProdutoRequestDTO dto) {
		try {
			Produto entity = produtoAssembler.toEntity(dto);
			return produtoRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}

	}

	@Transactional
	public Produto update(Long id, ProdutoRequestDTO dto) {
		Produto entity = produtoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		produtoAssembler.copyToEntity(dto, entity);
		return produtoRepository.save(entity);

	}

	public void delete(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}
