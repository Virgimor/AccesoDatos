package ies.jandula.Ejercicio4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.Ejercicio4.models.Empleado;
import ies.jandula.Ejercicio4.models.EmpleadoId;

public interface EmpleadosRepository extends JpaRepository<Empleado, EmpleadoId>{
	

}
