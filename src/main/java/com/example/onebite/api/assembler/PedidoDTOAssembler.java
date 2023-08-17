package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.PedidoResponseDTO;
import com.example.onebite.domain.model.Pedido;

@Component
public class PedidoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public PedidoResponseDTO toDto(Pedido entity) {
		return modelMapper.map(entity, PedidoResponseDTO.class);
	}

	public List<PedidoResponseDTO> toCollectionDto(List<Pedido> list) {
		return list.stream().map(pedido -> toDto(pedido)).toList();
	}

}
