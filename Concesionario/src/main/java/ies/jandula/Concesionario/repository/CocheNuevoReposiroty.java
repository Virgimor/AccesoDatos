package ies.jandula.Concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.models.CocheNuevo;

public interface CocheNuevoReposiroty extends JpaRepository<CocheNuevo, Coche>{

}
