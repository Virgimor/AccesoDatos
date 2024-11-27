package ies.jandula.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Biblioteca.models.Evento;
import ies.jandula.Biblioteca.models.EventoId;

public interface EventoRepository extends JpaRepository<Evento, EventoId>{

}
