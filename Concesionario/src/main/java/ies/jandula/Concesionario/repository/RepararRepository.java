package ies.jandula.Concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Concesionario.models.Reparar;
import ies.jandula.Concesionario.models.RepararId;

public interface RepararRepository extends JpaRepository<Reparar, RepararId>{

}
