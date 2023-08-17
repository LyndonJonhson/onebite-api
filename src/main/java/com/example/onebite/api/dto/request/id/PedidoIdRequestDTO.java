package com.example.onebite.api.dto.request.id;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class PedidoIdRequestDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
