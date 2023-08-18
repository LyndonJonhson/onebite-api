package com.example.onebite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.onebite.api.assembler.PapelDTOAssembler;
import com.example.onebite.api.dto.response.PapelResponseDTO;
import com.example.onebite.domain.model.Usuario;
import com.example.onebite.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuarios/{usuarioId}/papeis")
public class UsuarioPapelController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PapelDTOAssembler papelDTOAssembler;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PapelResponseDTO> listar(@PathVariable Long usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);
		return papelDTOAssembler.toCollectionDto(usuario.getPapeis());
	}
	
	@PutMapping("/{papelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long usuarioId, @PathVariable Long papelId) {
		usuarioService.associarPapel(usuarioId, papelId);
	}
	
	@DeleteMapping("/{papelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long usuarioId, @PathVariable Long papelId) {
		usuarioService.desassociarPapel(usuarioId, papelId);
	}
	
}
