package com.owlplan.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Turma;

public class TurmaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String apelido;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String serie;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String periodo;
	
	private Integer professorId;
	
	private Integer escolaId;
	
	public TurmaDTO() {
	}
	
	public TurmaDTO(Turma obj) {
		super();
		id = obj.getId();
		apelido = obj.getApelido();
		serie = obj.getSerie();
		periodo = obj.getPeriodo();
		professorId = obj.getProfessor().getId();
		escolaId = obj.getEscola().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}

	public Integer getEscolaId() {
		return escolaId;
	}

	public void setEscolaId(Integer escolaId) {
		this.escolaId = escolaId;
	}
	
}
