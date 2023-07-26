package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.BairroResponseDTO;
import com.example.onebite.domain.model.Bairro;

@Component
public class BairroDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public BairroResponseDTO toDto(Bairro entity) {
		return modelMapper.map(entity, BairroResponseDTO.class);
	}

	public List<BairroResponseDTO> toCollectionDto(List<Bairro> list) {
		return list.stream().map(bairro -> toDto(bairro)).toList();
	}

}
