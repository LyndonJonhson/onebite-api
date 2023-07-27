package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.UsuarioRequestDTO;
import com.example.onebite.api.dto.request.UsuarioResumoRequestDTO;
import com.example.onebite.domain.model.Usuario;

@Component
public class UsuarioAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Usuario toEntity(UsuarioRequestDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}

	public void copyToEntity(UsuarioRequestDTO dto, Usuario entity) {
		modelMapper.map(dto, entity);
	}
	
	public void copyToEntity(UsuarioResumoRequestDTO dto, Usuario entity) {
		modelMapper.map(dto, entity);
	}

}
