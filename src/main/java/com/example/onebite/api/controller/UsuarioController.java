package com.example.onebite.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.onebite.api.assembler.UsuarioDTOAssembler;
import com.example.onebite.api.dto.request.UsuarioRequestDTO;
import com.example.onebite.api.dto.request.UsuarioResumoRequestDTO;
import com.example.onebite.api.dto.response.UsuarioResponseDTO;
import com.example.onebite.domain.model.Usuario;
import com.example.onebite.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioDTOAssembler usuarioDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioResponseDTO> findAll() {
		List<Usuario> list = usuarioService.findAll();
		return usuarioDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDTO findById(@PathVariable Long id) {
		Usuario entity = usuarioService.findById(id);
		return usuarioDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDTO insert(@Valid @RequestBody UsuarioRequestDTO dto) {
		Usuario entity = usuarioService.insert(dto);
		return usuarioDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioResponseDTO update(@PathVariable Long id, @Valid @RequestBody UsuarioResumoRequestDTO dto) {
		Usuario entity = usuarioService.update(id, dto);
		return usuarioDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}

}
