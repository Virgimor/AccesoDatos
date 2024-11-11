package ies.jandula.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
