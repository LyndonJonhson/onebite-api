package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.PapelResponseDTO;
import com.example.onebite.domain.model.Papel;

@Component
public class PapelDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public PapelResponseDTO toDto(Papel entity) {
		return modelMapper.map(entity, PapelResponseDTO.class);
	}

	public List<PapelResponseDTO> toCollectionDto(List<Papel> list) {
		return list.stream().map(papel -> toDto(papel)).toList();
	}

}
