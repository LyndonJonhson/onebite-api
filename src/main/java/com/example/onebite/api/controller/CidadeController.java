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

import com.example.onebite.api.assembler.CidadeDTOAssembler;
import com.example.onebite.api.dto.CidadeDTO;
import com.example.onebite.api.dto.input.CidadeInputDTO;
import com.example.onebite.domain.model.Cidade;
import com.example.onebite.domain.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private CidadeDTOAssembler cidadeDTOAssembler;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CidadeDTO> findAll() {
		List<Cidade> list = cidadeService.findAll();
		return cidadeDTOAssembler.toCollectionDto(list);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeDTO findById(@PathVariable Long id) {
		Cidade entity = cidadeService.findById(id);
		return cidadeDTOAssembler.toDto(entity);	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeDTO insert(@Valid @RequestBody CidadeInputDTO dto) {
		Cidade entity = cidadeService.insert(dto);
		return cidadeDTOAssembler.toDto(entity);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeDTO update(@PathVariable Long id, @Valid @RequestBody CidadeInputDTO dto) {
		Cidade entity = cidadeService.update(id, dto);
		return cidadeDTOAssembler.toDto(entity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cidadeService.delete(id);
	}
	
}
