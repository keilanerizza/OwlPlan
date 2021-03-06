package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
