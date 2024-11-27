package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Revista;
import ies.jandula.Biblioteca.models.RevistaId;

public interface RevistaRepository extends JpaRepository<Revista, RevistaId>{

}
