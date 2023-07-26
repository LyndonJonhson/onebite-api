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

import com.example.onebite.api.assembler.EstadoDTOAssembler;
import com.example.onebite.api.dto.request.EstadoRequestDTO;
import com.example.onebite.api.dto.response.EstadoResponseDTO;
import com.example.onebite.domain.model.Estado;
import com.example.onebite.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private EstadoDTOAssembler estadoDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<EstadoResponseDTO> findAll() {
		List<Estado> list = estadoService.findAll();
		return estadoDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstadoResponseDTO findById(@PathVariable Long id) {
		Estado entity = estadoService.findById(id);
		return estadoDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoResponseDTO insert(@Valid @RequestBody EstadoRequestDTO dto) {
		Estado entity = estadoService.insert(dto);
		return estadoDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstadoResponseDTO update(@PathVariable Long id, @Valid @RequestBody EstadoRequestDTO dto) {
		Estado entity = estadoService.update(id, dto);
		return estadoDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		estadoService.delete(id);
	}

}
