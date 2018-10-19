package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Escola;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.UsuarioNewEscolaDTO;
import com.owlplan.repositories.EscolaRepository;
import com.owlplan.repositories.UsuarioRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class EscolaService {

	@Autowired
	private EscolaRepository repo;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Escola find(Integer id) {
		Optional<Escola> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Escola.class.getName()));
	}
	
	public Escola insert(Escola obj) {
		obj.setId(null);
		Usuario user = new Usuario(usuarioRepository.findByLastId(), null, null, null, null);
		obj.setUsuario(user);
		return repo.save(obj);
	}
	
	public List<Escola> findAll() {
		return repo.findAll();
	}
	
	public Escola fromDTO(UsuarioNewEscolaDTO objDto, Usuario user) {
		Escola esc = new Escola(null, objDto.getTelefone(), user);
		return esc;
	}
}
