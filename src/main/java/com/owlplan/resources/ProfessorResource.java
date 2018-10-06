package com.owlplan.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Professor;

@RestController
@RequestMapping(value="/professores")
public class ProfessorResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Professor> listar() {
		
		Date data = new Date();
		data.getTime();
		
		Professor prof1 = new Professor(1, "Fulana", data, "F");
		Professor prof2 = new Professor(2, "Ciclana", data, "F");
		
		List<Professor> lista = new ArrayList<>();
		lista.add(prof1);
		lista.add(prof2);
		
		return lista;
	}

}
