package com.owlplan.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Evento;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Evento> listar() {
		
		Date data = new Date();
		data.getTime();
		
		Evento evnt1 = new Evento(1, data, "Festa Junina");
		Evento evnt2 = new Evento(2, data, "Dia do Índio");
		
		List<Evento> lista = new ArrayList<>();
		lista.add(evnt1);
		lista.add(evnt2);
		
		return lista;
	}

}
