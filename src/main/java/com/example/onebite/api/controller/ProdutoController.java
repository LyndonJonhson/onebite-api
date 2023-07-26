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

import com.example.onebite.api.assembler.ProdutoDTOAssembler;
import com.example.onebite.api.dto.request.ProdutoRequestDTO;
import com.example.onebite.api.dto.response.ProdutoResponseDTO;
import com.example.onebite.domain.model.Produto;
import com.example.onebite.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoDTOAssembler produtoDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProdutoResponseDTO> findAll() {
		List<Produto> list = produtoService.findAll();
		return produtoDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProdutoResponseDTO findById(@PathVariable Long id) {
		Produto entity = produtoService.findById(id);
		return produtoDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoResponseDTO insert(@Valid @RequestBody ProdutoRequestDTO dto) {
		Produto entity = produtoService.insert(dto);
		return produtoDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProdutoResponseDTO update(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO dto) {
		Produto entity = produtoService.update(id, dto);
		return produtoDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoService.delete(id);
	}

}
