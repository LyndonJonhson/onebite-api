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

import com.example.onebite.api.assembler.PapelDTOAssembler;
import com.example.onebite.api.dto.request.PapelRequestDTO;
import com.example.onebite.api.dto.response.PapelResponseDTO;
import com.example.onebite.domain.model.Papel;
import com.example.onebite.domain.service.PapelService;

@RestController
@RequestMapping("/papeis")
public class PapelController {

	@Autowired
	private PapelService papelService;

	@Autowired
	private PapelDTOAssembler papelDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PapelResponseDTO> findAll() {
		List<Papel> list = papelService.findAll();
		return papelDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PapelResponseDTO findById(@PathVariable Long id) {
		Papel entity = papelService.findById(id);
		return papelDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PapelResponseDTO insert(@Valid @RequestBody PapelRequestDTO dto) {
		Papel entity = papelService.insert(dto);
		return papelDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PapelResponseDTO update(@PathVariable Long id, @Valid @RequestBody PapelRequestDTO dto) {
		Papel entity = papelService.update(id, dto);
		return papelDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		papelService.delete(id);
	}

}
