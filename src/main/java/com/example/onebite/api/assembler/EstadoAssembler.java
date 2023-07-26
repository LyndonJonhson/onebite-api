package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.EstadoRequestDTO;
import com.example.onebite.domain.model.Estado;

@Component
public class EstadoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Estado toEntity(EstadoRequestDTO dto) {
		return modelMapper.map(dto, Estado.class);
	}

	public void copyToEntity(EstadoRequestDTO dto, Estado entity) {
		modelMapper.map(dto, entity);
	}

}
