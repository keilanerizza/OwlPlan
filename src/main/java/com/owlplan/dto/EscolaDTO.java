package com.owlplan.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Escola;

public class EscolaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone;
	
	private String usuarioNome;
	
	public EscolaDTO() {
	}
	
	public EscolaDTO(Escola obj) {
		super();
		id = obj.getId();
		telefone = obj.getTelefone();
		setUsuarioNome(obj.getUsuario().getNome());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}	
}
