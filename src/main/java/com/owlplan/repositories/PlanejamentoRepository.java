package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Planejamento;

@Repository
public interface PlanejamentoRepository extends JpaRepository<Planejamento, Integer> {

}
