package com.owlplan.dto;

import java.io.Serializable;

public class UsuarioNewEscolaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	private Integer perfilId;
	
	public UsuarioNewEscolaDTO() {
		super();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getPerfilId() {
		return perfilId;
	}
	
	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}
}
