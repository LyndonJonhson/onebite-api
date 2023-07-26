package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.ProdutoRequestDTO;
import com.example.onebite.domain.model.Produto;

@Component
public class ProdutoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Produto toEntity(ProdutoRequestDTO dto) {
		return modelMapper.map(dto, Produto.class);
	}

	public void copyToEntity(ProdutoRequestDTO dto, Produto entity) {
		modelMapper.map(dto, entity);
	}

}
