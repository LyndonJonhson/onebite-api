package com.example.onebite.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.example.onebite.api.assembler.RestauranteDTOAssembler;
import com.example.onebite.api.dto.request.RestauranteRequestDTO;
import com.example.onebite.api.dto.response.RestauranteResponseDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Restaurante;
import com.example.onebite.domain.service.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@Autowired
	private RestauranteDTOAssembler restauranteDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<RestauranteResponseDTO> findAll() {
		List<Restaurante> list = restauranteService.findAll();
		return restauranteDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RestauranteResponseDTO findById(@PathVariable Long id) {
		Restaurante entity = restauranteService.findById(id);
		return restauranteDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteResponseDTO insert(@Valid @RequestBody RestauranteRequestDTO dto) {
		Restaurante entity = restauranteService.insert(dto);
		return restauranteDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RestauranteResponseDTO update(@PathVariable Long id, @Valid @RequestBody RestauranteRequestDTO dto) {
		try {
			Restaurante entity = restauranteService.update(id, dto);
			return restauranteDTOAssembler.toDto(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(
					String.format(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem(), dto.getEndereco()));
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		restauranteService.delete(id);
	}

}
