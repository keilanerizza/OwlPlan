package com.owlplan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Aluno;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Aluno> listar() {
		
		Aluno a1 = new Aluno(1, "aluno1", "M");
		Aluno a2 = new Aluno(2, "aluno2", "F");
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		
		return lista;
	}

}
