package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.ItemPedidoResponseDTO;
import com.example.onebite.domain.model.ItemPedido;

@Component
public class ItemPedidoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ItemPedidoResponseDTO toDto(ItemPedido entity) {
		return modelMapper.map(entity, ItemPedidoResponseDTO.class);
	}

	public List<ItemPedidoResponseDTO> toCollectionDto(List<ItemPedido> list) {
		return list.stream().map(itemPedido -> toDto(itemPedido)).toList();
	}

}
