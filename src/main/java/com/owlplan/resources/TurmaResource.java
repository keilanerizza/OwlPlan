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

import com.owlplan.domain.Turma;
import com.owlplan.dto.TurmaDTO;
import com.owlplan.services.TurmaService;

@RestController
@RequestMapping(value="/turmas")
public class TurmaResource {
	
	@Autowired
	private TurmaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Turma> find(@PathVariable Integer id) {
		Turma obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TurmaDTO>> findAll() {
		System.out.println("resource");
		List<Turma> list = service.findAll();
		List<TurmaDTO> listDto = list.stream().map(obj -> new TurmaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TurmaDTO objDto){
		Turma objTurma = service.fromDTO(objDto);
		objTurma = service.insert(objTurma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(objTurma.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
