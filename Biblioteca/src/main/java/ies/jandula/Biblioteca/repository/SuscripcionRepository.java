package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Suscripcion;
import ies.jandula.Biblioteca.models.SuscripcionId;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, SuscripcionId>{

}
