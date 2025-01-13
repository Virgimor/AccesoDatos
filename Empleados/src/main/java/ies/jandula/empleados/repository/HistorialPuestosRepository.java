package ies.jandula.empleados.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.empleados.dtos.Consulta64;
import ies.jandula.empleados.models.HistorialPuestos;
import ies.jandula.empleados.models.HistorialPuestosId;

public interface HistorialPuestosRepository extends JpaRepository<HistorialPuestos, HistorialPuestosId>{
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta64(h.historialPuestosId.empleados, h.historialPuestosId.fechaInicio, h.fechaFin, h.departamentos.idDepartamento, p.tituloPuesto) "
			+ "FROM HistorialPuestos h "
			+ "JOIN h.puestos p "
			+ "WHERE h.fechaFin = "
				+ "(SELECT MAX(h2.fechaFin) "
				+ "FROM HistorialPuestos h2 "
				+ "WHERE h2.empleados.idEmpleado = h.empleados.idEmpleado)") 
	Page<Consulta64> mostrarHistoricoConNombrePuestos(Pageable pageable);

}
