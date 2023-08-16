package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.PermissaoRequestDTO;
import com.example.onebite.domain.model.Permissao;

@Component
public class PermissaoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Permissao toEntity(PermissaoRequestDTO dto) {
		return modelMapper.map(dto, Permissao.class);
	}

	public void copyToEntity(PermissaoRequestDTO dto, Permissao entity) {
		modelMapper.map(dto, entity);
	}

}
