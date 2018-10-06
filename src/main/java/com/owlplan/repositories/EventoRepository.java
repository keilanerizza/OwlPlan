package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
