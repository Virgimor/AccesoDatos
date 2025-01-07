package ies.jandula.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.empleados.models.HistorialPuestos;
import ies.jandula.empleados.models.HistorialPuestosId;

public interface HistorialPuestosRepository extends JpaRepository<HistorialPuestos, HistorialPuestosId>{

}
