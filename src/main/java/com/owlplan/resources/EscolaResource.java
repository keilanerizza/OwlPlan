package com.owlplan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Escola;

@RestController
@RequestMapping(value="/escolas")
public class EscolaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Escola> listar() {
		
		Escola esc1 = new Escola(1, "EMEI Profª. Carmelita Vieira dos Santos");
		Escola esc2 = new Escola(2, "EMEI Zacarias Pereira da Silva");
		
		List<Escola> lista = new ArrayList<>();
		lista.add(esc1);
		lista.add(esc2);
		
		return lista;
	}

}
