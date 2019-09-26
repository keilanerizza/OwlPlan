package com.owlplan.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.owlplan.domain.Evento;
import com.owlplan.dto.EventoDTO;
import com.owlplan.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {

	@Autowired
	private EventoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Evento> find(@PathVariable Integer id) {
		Evento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EventoDTO>> findAll() {
		List<Evento> list = service.findAll();
		List<EventoDTO> listDto = list.stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EventoDTO objDto){
		Evento objEvento = service.fromDTO(objDto);
		objEvento = service.insert(objEvento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(objEvento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
