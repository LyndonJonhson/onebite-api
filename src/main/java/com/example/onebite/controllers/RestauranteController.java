package com.example.onebite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onebite.dto.RestauranteDTO;
import com.example.onebite.entities.Restaurante;
import com.example.onebite.services.RestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService service;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> findAll() {
		List<Restaurante> list = service.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestauranteDTO> findById(@PathVariable Long id) {
		RestauranteDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
}
