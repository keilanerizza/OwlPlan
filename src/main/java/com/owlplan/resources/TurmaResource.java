package com.owlplan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Turma;

@RestController
@RequestMapping(value="/turmas")
public class TurmaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Turma> listar() {
		
		Turma t1 = new Turma(1, "turma1", "1", "matutino");
		Turma t2 = new Turma(2, "turma2", "2", "matutino");
		
		List<Turma> lista = new ArrayList<>();
		lista.add(t1);
		lista.add(t2);
		
		return lista;
	}

}
