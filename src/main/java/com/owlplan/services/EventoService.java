package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Evento;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.EventoDTO;
import com.owlplan.repositories.EventoRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repo;
	
	public Evento insert(Evento obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Evento.class.getName()));
	}
	
	public List<Evento> findAll() {
		return repo.findAll();
	}
	
	public Evento fromDTO(EventoDTO objDto) {
		Usuario usuario = new Usuario(objDto.getUsuarioId(), null, null, null, null);
		Evento evento = new Evento(null, objDto.getData(), objDto.getDescricao(), usuario);
		return evento;
	}
}
