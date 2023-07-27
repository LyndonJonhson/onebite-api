package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.ItemPedidoRequestDTO;
import com.example.onebite.domain.model.ItemPedido;
import com.example.onebite.domain.model.Produto;

@Component
public class ItemPedidoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ItemPedido toEntity(ItemPedidoRequestDTO dto) {
		return modelMapper.map(dto, ItemPedido.class);
	}

	public void copyToEntity(ItemPedidoRequestDTO dto, ItemPedido entity) {
		entity.setProduto(new Produto());
		modelMapper.map(dto, entity);
	}

}
