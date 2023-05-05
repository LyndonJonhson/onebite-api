package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.EstadoResponseDTO;
import com.example.onebite.domain.model.Estado;

@Component
public class EstadoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public EstadoResponseDTO toDto(Estado entity) {
		return modelMapper.map(entity, EstadoResponseDTO.class);
	}

	public List<EstadoResponseDTO> toCollectionDto(List<Estado> list) {
		return list.stream().map(estado -> toDto(estado)).toList();
	}

}
