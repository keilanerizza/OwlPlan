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

import com.owlplan.domain.Professor;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.ProfessorDTO;
import com.owlplan.dto.UsuarioNewProfessorDTO;
import com.owlplan.services.ProfessorService;
import com.owlplan.services.UsuarioService;

@RestController
@RequestMapping(value="/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewProfessorDTO objDto){
		Usuario obj = usuarioService.fromDTO(objDto);
		obj = usuarioService.insert(obj);
		Professor objProfessor = service.fromDTO(objDto, obj);
		objProfessor = service.insert(objProfessor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
