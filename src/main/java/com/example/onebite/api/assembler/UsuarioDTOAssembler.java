package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.UsuarioResponseDTO;
import com.example.onebite.domain.model.Usuario;

@Component
public class UsuarioDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public UsuarioResponseDTO toDto(Usuario entity) {
		return modelMapper.map(entity, UsuarioResponseDTO.class);
	}

	public List<UsuarioResponseDTO> toCollectionDto(List<Usuario> list) {
		return list.stream().map(usuario -> toDto(usuario)).toList();
	}

}
