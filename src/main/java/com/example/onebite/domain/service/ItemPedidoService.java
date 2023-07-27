package com.example.onebite.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onebite.api.assembler.ItemPedidoAssembler;
import com.example.onebite.api.dto.request.ItemPedidoRequestDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.EntidadeEmUsoException;
import com.example.onebite.domain.exception.EntidadeNaoEncontradaException;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.ItemPedido;
import com.example.onebite.domain.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ItemPedidoAssembler itemPedidoAssembler;

	@Transactional(readOnly = true)
	public List<ItemPedido> findAll() {
		return itemPedidoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public ItemPedido findById(Long id) {
		return itemPedidoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
	}

	@Transactional
	public ItemPedido insert(ItemPedidoRequestDTO dto) {
		try {
			ItemPedido entity = itemPedidoAssembler.toEntity(dto);
			return itemPedidoRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem());
		}

	}

	@Transactional
	public ItemPedido update(Long id, ItemPedidoRequestDTO dto) {
		ItemPedido entity = itemPedidoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id)));
		itemPedidoAssembler.copyToEntity(dto, entity);
		return itemPedidoRepository.save(entity);

	}

	public void delete(Long id) {
		try {
			itemPedidoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(Mensagem.ENTIDADE_NAO_ENCONTRADA.getMensagem(), id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Mensagem.ENTIDADE_EM_USO.getMensagem(), id));
		}
	}

}
