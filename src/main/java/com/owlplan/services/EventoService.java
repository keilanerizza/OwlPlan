package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Evento;
import com.owlplan.repositories.EventoRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repo;
	
	public Evento find(Integer id) {
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Evento.class.getName()));
	}
	
	public List<Evento> findAll() {
		return repo.findAll();
	}
}
