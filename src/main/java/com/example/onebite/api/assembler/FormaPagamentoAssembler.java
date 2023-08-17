package com.example.onebite.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.FormaPagamentoRequestDTO;
import com.example.onebite.domain.model.FormaPagamento;

@Component
public class FormaPagamentoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FormaPagamento toEntity(FormaPagamentoRequestDTO dto) {
		return modelMapper.map(dto, FormaPagamento.class);
	}

	public void copyToEntity(FormaPagamentoRequestDTO dto, FormaPagamento entity) {
		modelMapper.map(dto, entity);
	}

}
