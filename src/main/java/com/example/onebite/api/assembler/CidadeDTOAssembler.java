package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.CidadeDTO;
import com.example.onebite.domain.model.Cidade;

@Component
public class CidadeDTOAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CidadeDTO toDto(Cidade entity) {
		return modelMapper.map(entity, CidadeDTO.class);
	}
	
	public List<CidadeDTO> toCollectionDto(List<Cidade> list) {
		return list.stream()
				.map(cidade -> toDto(cidade))
				.toList();
	}
	
}
