package com.owlplan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Planejamento;

@RestController
@RequestMapping(value="/planos")
public class PlanejamentoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Planejamento> listar() {
		
		Planejamento p1 = new Planejamento(1, "plano1", "caminho/plano/1");
		Planejamento p2 = new Planejamento(2, "plano2", "caminho/plano/2");
		
		List<Planejamento> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		
		return lista;
	}

}
