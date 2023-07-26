package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.RestauranteRequestDTO;
import com.example.onebite.domain.model.Endereco;
import com.example.onebite.domain.model.Restaurante;

@Component
public class RestauranteAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Restaurante toEntity(RestauranteRequestDTO dto) {
		return modelMapper.map(dto, Restaurante.class);
	}

	public void copyToEntity(RestauranteRequestDTO dto, Restaurante entity) {
		entity.setEndereco(new Endereco());
		modelMapper.map(dto, entity);
	}

}
