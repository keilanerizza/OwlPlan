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

import com.owlplan.domain.Escola;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.EscolaDTO;
import com.owlplan.dto.UsuarioNewEscolaDTO;
import com.owlplan.services.EscolaService;
import com.owlplan.services.UsuarioService;

@RestController
@RequestMapping(value="/escola")
public class EscolaResource {
	
	@Autowired
	private EscolaService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewEscolaDTO objDto){
		Usuario obj = usuarioService.fromDTO(objDto);
		obj = usuarioService.insert(obj);
		Escola objEscola = service.fromDTO(objDto, obj);
		objEscola = service.insert(objEscola);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
