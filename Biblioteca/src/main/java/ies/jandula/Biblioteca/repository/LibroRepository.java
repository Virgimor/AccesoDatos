package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Libro;
import ies.jandula.Biblioteca.models.LibroId;

public interface LibroRepository extends JpaRepository<Libro, LibroId>{

	
}
