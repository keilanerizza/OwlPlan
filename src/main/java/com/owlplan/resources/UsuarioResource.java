package com.owlplan.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.owlplan.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario user1 = new Usuario(1, "usuario1@teste.com", "usuario1");
		Usuario user2 = new Usuario(2, "usuario2@teste.com", "usuario2");
		
		List<Usuario> lista = new ArrayList<>();
		lista.add(user1);
		lista.add(user2);
		
		return lista;
	}

}
