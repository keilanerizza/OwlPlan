package com.owlplan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String apelido;
	private String serie;
	private String periodo;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="escola_id")
	private Escola escola;
	
	@JsonIgnore
	@OneToMany(mappedBy="turma")
	private List<Aluno> alunos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="turma")
	private List<Planejamento> planos = new ArrayList<>();
	
	public Turma() {
	}
	
	public Turma(Integer id, String apelido, String serie, String periodo) {
		super();
		this.id = id;
		this.apelido = apelido;
		this.serie = serie;
		this.periodo = periodo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
