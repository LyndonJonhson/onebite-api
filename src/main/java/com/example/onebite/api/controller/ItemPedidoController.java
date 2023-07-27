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

import com.example.onebite.api.assembler.ItemPedidoDTOAssembler;
import com.example.onebite.api.dto.request.ItemPedidoRequestDTO;
import com.example.onebite.api.dto.response.ItemPedidoResponseDTO;
import com.example.onebite.domain.model.ItemPedido;
import com.example.onebite.domain.service.ItemPedidoService;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private ItemPedidoDTOAssembler itemPedidoDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ItemPedidoResponseDTO> findAll() {
		List<ItemPedido> list = itemPedidoService.findAll();
		return itemPedidoDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ItemPedidoResponseDTO findById(@PathVariable Long id) {
		ItemPedido entity = itemPedidoService.findById(id);
		return itemPedidoDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ItemPedidoResponseDTO insert(@Valid @RequestBody ItemPedidoRequestDTO dto) {
		ItemPedido entity = itemPedidoService.insert(dto);
		return itemPedidoDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ItemPedidoResponseDTO update(@PathVariable Long id, @Valid @RequestBody ItemPedidoRequestDTO dto) {
		ItemPedido entity = itemPedidoService.update(id, dto);
		return itemPedidoDTOAssembler.toDto(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itemPedidoService.delete(id);
	}

}
