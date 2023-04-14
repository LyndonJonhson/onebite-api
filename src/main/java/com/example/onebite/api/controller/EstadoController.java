package com.example.onebite.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.onebite.api.dto.EstadoDTO;
import com.example.onebite.api.dto.Groups;
import com.example.onebite.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<EstadoDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstadoDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO insert(@Validated(Groups.InsertEstado.class) @RequestBody EstadoDTO dto) {
		return service.insert(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EstadoDTO update(@PathVariable Long id, @Valid @RequestBody EstadoDTO dto) {
		return service.update(id, dto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
