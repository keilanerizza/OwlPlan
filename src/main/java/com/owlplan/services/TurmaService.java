package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Escola;
import com.owlplan.domain.Professor;
import com.owlplan.domain.Turma;
import com.owlplan.dto.TurmaDTO;
import com.owlplan.repositories.TurmaRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repo;
	
	public Turma insert(Turma obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Turma find(Integer id) {
		Optional<Turma> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}
	
	public List<Turma> findAll() {
		System.out.println("TurmaService");
		return repo.findAll();
	}
	
	public Turma fromDTO(TurmaDTO objDto) {
		Professor professor = new Professor(objDto.getProfessorId(), null, null, null);
		Escola escola = new Escola(objDto.getEscolaId(), null, null);
		Turma turma = new Turma(null, objDto.getApelido(), objDto.getSerie(), objDto.getPeriodo(), professor, escola);
		return turma;
	}

}
