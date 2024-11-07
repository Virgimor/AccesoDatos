package ies.jandula.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.models.Matricula;
import ies.jandula.universidad.models.MatriculaId;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaId>{

}
