package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.CidadeResponseDTO;
import com.example.onebite.domain.model.Cidade;

@Component
public class CidadeDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CidadeResponseDTO toDto(Cidade entity) {
		return modelMapper.map(entity, CidadeResponseDTO.class);
	}

	public List<CidadeResponseDTO> toCollectionDto(List<Cidade> list) {
		return list.stream().map(cidade -> toDto(cidade)).toList();
	}

}
