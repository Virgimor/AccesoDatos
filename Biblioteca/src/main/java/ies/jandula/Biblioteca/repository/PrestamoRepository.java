package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Prestamo;
import ies.jandula.Biblioteca.models.PrestamoId;

public interface PrestamoRepository extends JpaRepository<Prestamo, PrestamoId>{

}
