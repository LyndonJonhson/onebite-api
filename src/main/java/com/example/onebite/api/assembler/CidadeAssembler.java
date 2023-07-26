package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.CidadeRequestDTO;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.model.Estado;

@Component
public class CidadeAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Cidade toEntity(CidadeRequestDTO dto) {
		return modelMapper.map(dto, Cidade.class);
	}

	public void copyToEntity(CidadeRequestDTO dto, Cidade entity) {
		entity.setEstado(new Estado());
		modelMapper.map(dto, entity);
	}

}
