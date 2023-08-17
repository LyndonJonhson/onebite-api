package com.example.onebite.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.response.FormaPagamentoResponseDTO;
import com.example.onebite.domain.model.FormaPagamento;

@Component
public class FormaPagamentoDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public FormaPagamentoResponseDTO toDto(FormaPagamento entity) {
		return modelMapper.map(entity, FormaPagamentoResponseDTO.class);
	}

	public List<FormaPagamentoResponseDTO> toCollectionDto(List<FormaPagamento> list) {
		return list.stream().map(formaPagamento -> toDto(formaPagamento)).toList();
	}

}
