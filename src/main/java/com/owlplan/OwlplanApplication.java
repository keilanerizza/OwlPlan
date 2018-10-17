package com.owlplan;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owlplan.domain.Professor;
import com.owlplan.domain.Usuario;
import com.owlplan.repositories.ProfessorRepository;
import com.owlplan.repositories.UsuarioRepository;

@SpringBootApplication
public class OwlplanApplication implements CommandLineRunner {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ProfessorRepository professorRepository;

	public static void main(String[] args) {
		SpringApplication.run(OwlplanApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		/*Usuario user1 = new Usuario(1, "user1@teste.com", "user1teste");
		Usuario user2 = new Usuario(2, "user2@teste.com", "user2teste");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Professor prof1 = new Professor(1, "Fulana", sdf.parse("02/10/1960"), "F", user1);
		Professor prof2 = new Professor(2, "Ciclana", sdf.parse("15/08/1970"), "F", user2);
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		professorRepository.saveAll(Arrays.asList(prof1, prof2));*/
	}
}
