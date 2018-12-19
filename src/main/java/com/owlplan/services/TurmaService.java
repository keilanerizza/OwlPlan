package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Escola;
import com.owlplan.domain.Professor;
import com.owlplan.domain.Turma;
import com.owlplan.dto.TurmaDTO;
import com.owlplan.repositories.TurmaRepository;
import com.owlplan.services.exceptions.DataIntegrityException;
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
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
		}
	}
	
	public Turma update(Turma obj) {
		Turma newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Turma newObj, Turma obj) {
		newObj.setApelido(obj.getApelido());
		newObj.setPeriodo(obj.getPeriodo());
		newObj.setSerie(obj.getSerie());
		newObj.setEscola(obj.getEscola());
		newObj.setProfessor(obj.getProfessor());
	}
	
	public Turma fromDTO(TurmaDTO objDto) {
		Professor professor = new Professor(objDto.getProfessorId(), null, null, null);
		Escola escola = new Escola(objDto.getEscolaId(), null, null);
		Turma turma = new Turma(null, objDto.getApelido(), objDto.getSerie(), objDto.getPeriodo(), professor, escola);
		return turma;
	}
	

}
