package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}
