package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.BairroRequestDTO;
import com.example.onebite.domain.model.Bairro;
import com.example.onebite.domain.model.Cidade;

@Component
public class BairroAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Bairro toEntity(BairroRequestDTO dto) {
		return modelMapper.map(dto, Bairro.class);
	}
	
	public void copyToEntity(BairroRequestDTO dto, Bairro entity) {
		entity.setCidade(new Cidade());
		modelMapper.map(dto, entity);
	}
	
}
