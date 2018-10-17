package com.owlplan.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Perfil;
import com.owlplan.dto.PerfilDTO;
import com.owlplan.services.PerfilService;

@RestController
@RequestMapping(value="/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Perfil> find(@PathVariable Integer id) {
		Perfil obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PerfilDTO>> findAll() {
		List<Perfil> list = service.findAll();
		List<PerfilDTO> listDto = list.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
