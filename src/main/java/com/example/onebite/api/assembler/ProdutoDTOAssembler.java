package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.ProdutoResponseDTO;
import com.example.onebite.domain.model.Produto;

@Component
public class ProdutoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public ProdutoResponseDTO toDto(Produto entity) {
		return modelMapper.map(entity, ProdutoResponseDTO.class);
	}

	public List<ProdutoResponseDTO> toCollectionDto(List<Produto> list) {
		return list.stream().map(produto -> toDto(produto)).toList();
	}

}
