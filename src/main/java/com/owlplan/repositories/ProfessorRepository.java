package com.owlplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owlplan.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
