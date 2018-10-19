package com.owlplan.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioNewProfessorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private String nome;
	private Date nascimento;
	private String sexo;
	private Integer perfilId;
	
	public UsuarioNewProfessorDTO() {
		super();
	}
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
