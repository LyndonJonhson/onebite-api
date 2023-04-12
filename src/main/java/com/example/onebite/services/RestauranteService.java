package com.example.onebite.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onebite.dto.RestauranteDTO;
import com.example.onebite.entities.Restaurante;
import com.example.onebite.repositories.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository repository;
	
	public List<Restaurante> findAll() {
		return repository.findAll();
	}
	
	public RestauranteDTO findById(Long id) {
		Optional<Restaurante> obj = repository.findById(id);
		Restaurante entity = obj.orElseThrow(() -> new EntityNotFoundException());
		return new RestauranteDTO(entity);
	}
	
}
