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

import com.example.onebite.api.assembler.CozinhaDTOAssembler;
import com.example.onebite.api.dto.request.CozinhaRequestDTO;
import com.example.onebite.api.dto.response.CozinhaResponseDTO;
import com.example.onebite.domain.model.Cozinha;
import com.example.onebite.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaService cozinhaService;
	
	@Autowired
	private CozinhaDTOAssembler cozinhaDTOAssembler;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CozinhaResponseDTO> findAll() {
		List<Cozinha> list = cozinhaService.findAll();
		return cozinhaDTOAssembler.toCollectionDto(list);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CozinhaResponseDTO findById(@PathVariable Long id) {
		Cozinha entity = cozinhaService.findById(id);
		return cozinhaDTOAssembler.toDto(entity);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaResponseDTO insert(@Valid @RequestBody CozinhaRequestDTO dto) {
		Cozinha entity = cozinhaService.insert(dto);
		return cozinhaDTOAssembler.toDto(entity);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CozinhaResponseDTO update(@PathVariable Long id, @Valid @RequestBody CozinhaRequestDTO dto) {
		Cozinha entity = cozinhaService.update(id, dto);
		return cozinhaDTOAssembler.toDto(entity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cozinhaService.delete(id);
	}
	
}
