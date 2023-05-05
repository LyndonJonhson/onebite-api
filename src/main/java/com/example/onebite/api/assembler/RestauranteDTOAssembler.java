package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.RestauranteResponseDTO;
import com.example.onebite.domain.model.Restaurante;

@Component
public class RestauranteDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public RestauranteResponseDTO toDto(Restaurante entity) {
		return modelMapper.map(entity, RestauranteResponseDTO.class);
	}

	public List<RestauranteResponseDTO> toCollectionDto(List<Restaurante> list) {
		return list.stream().map(restaurante -> toDto(restaurante)).toList();
	}

}
