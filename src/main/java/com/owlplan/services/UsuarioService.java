package com.owlplan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owlplan.domain.Perfil;
import com.owlplan.domain.Usuario;
import com.owlplan.dto.UsuarioDTO;
import com.owlplan.dto.UsuarioNewEscolaDTO;
import com.owlplan.dto.UsuarioNewProfessorDTO;
import com.owlplan.repositories.UsuarioRepository;
import com.owlplan.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setNome(obj.getNome());
	}
	
	public Usuario fromDTO(UsuarioNewProfessorDTO objDto) {
		Perfil perfil = new Perfil(objDto.getPerfilId(), null);
		Usuario user = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getSenha(), perfil);
		return user;
	}
	
	public Usuario fromDTO(UsuarioNewEscolaDTO objDto) {
		Perfil perfil = new Perfil(objDto.getPerfilId(), null);
		Usuario user = new Usuario(null, objDto.getNome(), objDto.getEmail(), objDto.getSenha(), perfil);
		return user;
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getSenha(), null);
	}
}
