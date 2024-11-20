package ies.jandula.Concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Concesionario.models.Coche;
import ies.jandula.Concesionario.models.CocheSeminuevo;

public interface CocheSeminuevoRepository extends JpaRepository<CocheSeminuevo, Coche>{

}
