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

import com.example.onebite.api.assembler.PermissaoDTOAssembler;
import com.example.onebite.api.dto.request.PermissaoRequestDTO;
import com.example.onebite.api.dto.response.PermissaoResponseDTO;
import com.example.onebite.domain.model.Permissao;
import com.example.onebite.domain.service.PermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoService permissaoService;

	@Autowired
	private PermissaoDTOAssembler permissaoDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PermissaoResponseDTO> findAll() {
		List<Permissao> list = permissaoService.findAll();
		return permissaoDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PermissaoResponseDTO findById(@PathVariable Long id) {
		Permissao entity = permissaoService.findById(id);
		return permissaoDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PermissaoResponseDTO insert(@Valid @RequestBody PermissaoRequestDTO dto) {
		Permissao entity = permissaoService.insert(dto);
		return permissaoDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PermissaoResponseDTO update(@PathVariable Long id, @Valid @RequestBody PermissaoRequestDTO dto) {
		Permissao entity = permissaoService.update(id, dto);
		return permissaoDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		permissaoService.delete(id);
	}

}
