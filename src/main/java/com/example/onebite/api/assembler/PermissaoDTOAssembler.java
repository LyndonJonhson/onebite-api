package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.PermissaoResponseDTO;
import com.example.onebite.domain.model.Permissao;

@Component
public class PermissaoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public PermissaoResponseDTO toDto(Permissao entity) {
		return modelMapper.map(entity, PermissaoResponseDTO.class);
	}

	public List<PermissaoResponseDTO> toCollectionDto(List<Permissao> list) {
		return list.stream().map(permissao -> toDto(permissao)).toList();
	}

}
