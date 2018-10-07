package com.owlplan.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		super();
		id = obj.getId();
		email = obj.getEmail();
		senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
