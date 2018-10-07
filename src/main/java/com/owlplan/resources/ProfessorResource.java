package com.owlplan.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Professor;
import com.owlplan.dto.ProfessorDTO;
import com.owlplan.services.ProfessorService;

@RestController
@RequestMapping(value="/professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Professor> find(@PathVariable Integer id) {
		Professor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> findAll() {
		List<Professor> list = service.findAll();
		List<ProfessorDTO> listDto = list.stream().map(obj -> new ProfessorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
