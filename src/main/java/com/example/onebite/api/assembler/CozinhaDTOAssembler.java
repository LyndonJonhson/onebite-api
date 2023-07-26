package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.CozinhaResponseDTO;
import com.example.onebite.domain.model.Cozinha;

@Component
public class CozinhaDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CozinhaResponseDTO toDto(Cozinha entity) {
		return modelMapper.map(entity, CozinhaResponseDTO.class);
	}

	public List<CozinhaResponseDTO> toCollectionDto(List<Cozinha> list) {
		return list.stream().map(cozinha -> toDto(cozinha)).toList();
	}

}
