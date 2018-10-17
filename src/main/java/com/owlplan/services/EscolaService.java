package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Escola;
import com.owlplan.repositories.EscolaRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository repo;

	public Escola find(Integer id) {
		Optional<Escola> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Escola.class.getName()));
	}
	
	public List<Escola> findAll() {
		return repo.findAll();
	}
}
