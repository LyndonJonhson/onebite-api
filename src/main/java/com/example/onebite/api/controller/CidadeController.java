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

import com.example.onebite.api.assembler.CidadeDTOAssembler;
import com.example.onebite.api.dto.request.CidadeRequestDTO;
import com.example.onebite.api.dto.response.CidadeResponseDTO;
import com.example.onebite.domain.enums.Mensagem;
import com.example.onebite.domain.exception.MensagemNaoCompreensivelException;
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
	public List<CidadeResponseDTO> findAll() {
		List<Cidade> list = cidadeService.findAll();
		return cidadeDTOAssembler.toCollectionDto(list);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeResponseDTO findById(@PathVariable Long id) {
		Cidade entity = cidadeService.findById(id);
		return cidadeDTOAssembler.toDto(entity);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeResponseDTO insert(@Valid @RequestBody CidadeRequestDTO dto) {
		Cidade entity = cidadeService.insert(dto);
		return cidadeDTOAssembler.toDto(entity);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CidadeResponseDTO update(@PathVariable Long id, @Valid @RequestBody CidadeRequestDTO dto) {
		try {
			Cidade entity = cidadeService.update(id, dto);
			return cidadeDTOAssembler.toDto(entity);
		} catch (DataIntegrityViolationException e) {
			throw new MensagemNaoCompreensivelException(
					String.format(Mensagem.MENSAGEM_NAO_COMPREENSIVEL.getMensagem(), dto.getEstado().getId()));
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cidadeService.delete(id);
	}

}
