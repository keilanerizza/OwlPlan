package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Professor;
import com.owlplan.repositories.ProfessorRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repo;

	public Professor find(Integer id) {
		Optional<Professor> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}
	
	public List<Professor> findAll() {
		return repo.findAll();
	}
}
