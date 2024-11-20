package ies.jandula.Concesionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Concesionario.models.Descuento;
import ies.jandula.Concesionario.models.DescuentoId;

public interface DescuentoRepository extends JpaRepository<Descuento, DescuentoId>{

}
