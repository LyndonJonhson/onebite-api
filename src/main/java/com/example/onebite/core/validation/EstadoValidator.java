package com.example.onebite.core.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.onebite.api.dto.EstadoDTO;
import com.example.onebite.api.exceptionhandler.FieldMessage;
import com.example.onebite.domain.model.Estado;
import com.example.onebite.domain.repository.EstadoRepository;

public class EstadoValidator implements ConstraintValidator<EstadoValid, EstadoDTO> {
	
	@Autowired
	private EstadoRepository repository;
	
	@Override
	public boolean isValid(EstadoDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		Estado nomeValid = repository.findByNome(dto.getNome());
		Estado siglaValid = repository.findBySigla(dto.getSigla());
		
		if (nomeValid != null)
			list.add(new FieldMessage("nome", "nome já existente"));
		if (siglaValid != null)
			list.add(new FieldMessage("sigla", "sigla já existente"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
		
	}

}
