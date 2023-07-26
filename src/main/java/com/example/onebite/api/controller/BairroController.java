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

import com.example.onebite.api.assembler.BairroDTOAssembler;
import com.example.onebite.api.dto.request.BairroRequestDTO;
import com.example.onebite.api.dto.response.BairroResponseDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
import com.example.onebite.domain.model.Bairro;
import com.example.onebite.domain.service.BairroService;

@RestController
@RequestMapping("/bairros")
public class BairroController {

	@Autowired
	private BairroService bairroService;

	@Autowired
	private BairroDTOAssembler bairroDTOAssembler;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<BairroResponseDTO> findAll() {
		List<Bairro> list = bairroService.findAll();
		return bairroDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BairroResponseDTO findById(@PathVariable Long id) {
		Bairro entity = bairroService.findById(id);
		return bairroDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BairroResponseDTO insert(@Valid @RequestBody BairroRequestDTO dto) {
		Bairro entity = bairroService.insert(dto);
		return bairroDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public BairroResponseDTO update(@PathVariable Long id, @Valid @RequestBody BairroRequestDTO dto) {
		try {
			Bairro entity = bairroService.update(id, dto);
			return bairroDTOAssembler.toDto(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(
					String.format(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem(), dto.getCidade().getId()));
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bairroService.delete(id);
	}

}
