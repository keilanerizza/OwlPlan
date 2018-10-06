package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
