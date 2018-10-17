package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Perfil;
import com.owlplan.repositories.PerfilRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repo;

	public Perfil find(Integer id) {
		Optional<Perfil> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}
	
	public List<Perfil> findAll() {
		return repo.findAll();
	}
}
