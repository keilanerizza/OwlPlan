package com.owlplan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Professor;
import com.owlplan.domain.Usuario;

public class ProfessorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Date nascimento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String sexo;
	
	private Usuario usuario;
	
	public ProfessorDTO() {
	}
	
	public ProfessorDTO(Professor obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		sexo = obj.getSexo();
		usuario = obj.getUsuario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
