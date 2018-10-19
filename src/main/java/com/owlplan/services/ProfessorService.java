package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Professor;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.UsuarioNewProfessorDTO;
import com.owlplan.repositories.ProfessorRepository;
import com.owlplan.repositories.UsuarioRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repo;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Professor find(Integer id) {
		Optional<Professor> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}
	
	public Professor insert(Professor obj) {
		obj.setId(null);
		Usuario user = new Usuario(usuarioRepository.findByLastId(), null, null, null, null);
		obj.setUsuario(user);
		return repo.save(obj);
	}
	
	public List<Professor> findAll() {
		return repo.findAll();
	}
	
	public Professor fromDTO(UsuarioNewProfessorDTO objDto, Usuario user) {
		Professor prof = new Professor(null, objDto.getNascimento(), objDto.getSexo(), user);
		return prof;
	}
	
	/*public Professor fromDTO(ProfessorDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha(), null);
	}*/
}
