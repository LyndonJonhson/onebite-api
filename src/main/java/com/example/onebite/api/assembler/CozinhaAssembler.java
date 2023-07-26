package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.CozinhaRequestDTO;
import com.example.onebite.domain.model.Cozinha;

@Component
public class CozinhaAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Cozinha toEntity(CozinhaRequestDTO dto) {
		return modelMapper.map(dto, Cozinha.class);
	}

	public void copyToEntity(CozinhaRequestDTO dto, Cozinha entity) {
		modelMapper.map(dto, entity);
	}

}
