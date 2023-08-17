package com.example.onebite.api.assembler;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.onebite.api.dto.request.PedidoRequestDTO;
import com.example.onebite.domain.model.Endereco;
import com.example.onebite.domain.model.FormaPagamento;
import com.example.onebite.domain.model.Pedido;
import com.example.onebite.domain.model.Restaurante;
import com.example.onebite.domain.model.Usuario;

@Component
public class PedidoAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public Pedido toEntity(PedidoRequestDTO dto) {
		return modelMapper.map(dto, Pedido.class);
	}

	public void copyToEntity(PedidoRequestDTO dto, Pedido entity) {
		entity.setItens(new ArrayList<>());
		entity.setCliente(new Usuario());
		entity.setRestaurante(new Restaurante());
		entity.setFormaPagamento(new FormaPagamento());
		entity.setEnderecoEntrega(new Endereco());
		modelMapper.map(dto, entity);
	}

}
