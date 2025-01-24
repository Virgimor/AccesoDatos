package es.iesjandula.examen_ud2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.examen_ud2.dtos_clase.Consulta64;
import es.iesjandula.examen_ud2.dtos_clase.Consulta81;
import es.iesjandula.examen_ud2.models.HistorialPuestos;
import es.iesjandula.examen_ud2.models.HistorialPuestosId;

public interface HistorialPuestosRepository extends JpaRepository<HistorialPuestos, HistorialPuestosId>{
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta64(h.historialPuestosId.empleados, h.historialPuestosId.fechaInicio, h.fechaFin, h.departamentos.idDepartamento, p.tituloPuesto) "
			+ "FROM HistorialPuestos h "
			+ "JOIN h.puestos p "
			+ "WHERE h.fechaFin = "
				+ "(SELECT MAX(h2.fechaFin) "
				+ "FROM HistorialPuestos h2 "
				+ "WHERE h2.empleados.idEmpleado = h.empleados.idEmpleado)") 
	Page<Consulta64> mostrarHistoricoConNombrePuestos(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta81(hp.empleados.idEmpleado, e.nombre, p.tituloPuesto, d.nombreDepartamento, hp.historialPuestosId.fechaInicio, hp.fechaFin) "
		     + "FROM HistorialPuestos hp "
		     + "JOIN hp.empleados e "
		     + "JOIN hp.puestos p "
		     + "JOIN hp.departamentos d "
		     + "WHERE hp.empleados.idEmpleado IN ("
		     + "    SELECT h.empleados.idEmpleado "
		     + "    FROM HistorialPuestos h "
		     + "    GROUP BY h.empleados.idEmpleado "
		     + "    HAVING COUNT(DISTINCT h.departamentos.idDepartamento) > 1"
		     + ") ")
	Page<Consulta81> obtenerHistorialDePuestosDeEmpleadosQueHanTrabajadoEnMasDeUnDepartamento(Pageable pageable);

}
