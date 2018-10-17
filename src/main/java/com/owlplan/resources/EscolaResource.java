package com.owlplan.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Escola;
import com.owlplan.dto.EscolaDTO;
import com.owlplan.services.EscolaService;

@RestController
@RequestMapping(value="/escolas")
public class EscolaResource {
	
	@Autowired
	private EscolaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Escola> find(@PathVariable Integer id) {
		Escola obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EscolaDTO>> findAll() {
		List<Escola> list = service.findAll();
		List<EscolaDTO> listDto = list.stream().map(obj -> new EscolaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
