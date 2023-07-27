package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.PapelRequestDTO;
import com.example.onebite.domain.model.Papel;

@Component
public class PapelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Papel toEntity(PapelRequestDTO dto) {
		return modelMapper.map(dto, Papel.class);
	}

	public void copyToEntity(PapelRequestDTO dto, Papel entity) {
		modelMapper.map(dto, entity);
	}

}
