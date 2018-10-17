package com.owlplan.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Perfil;

public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String descricao;

	public PerfilDTO() {
	}

	public PerfilDTO(Perfil obj) {
		super();
		id = obj.getId();
		descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
