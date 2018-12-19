package com.owlplan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.owlplan.domain.Evento;

public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer usuarioId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String descricao;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private Date data;

	public EventoDTO() {
	}

	public EventoDTO(Evento obj) {
		super();
		this.id = obj.getId();
		this.usuarioId = obj.getUsuario().getId();
		this.descricao = obj.getDescricao();
		this.data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		EventoDTO other = (EventoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
