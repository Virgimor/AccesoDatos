package es.iesjandula.examen_ud2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.examen_ud2.dtos_clase.Consulta10;
import es.iesjandula.examen_ud2.dtos_clase.Consulta25;
import es.iesjandula.examen_ud2.dtos_clase.Consulta34;
import es.iesjandula.examen_ud2.dtos_clase.Consulta45;
import es.iesjandula.examen_ud2.models.Puestos;

public interface PuestosRepository extends JpaRepository<Puestos, String>{
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta10(p.tituloPuesto) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE e.puestos is not null")
	List<Consulta10> encontrarPuestosConEmpleados();
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta25(p.tituloPuesto, p.salarioMax) "
			+ "FROM Puestos p "
			+ "ORDER BY p.salarioMax DESC")
	List<Consulta25> encontrarPuestosOrdenadosPorSalarioDesc();
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta34(p.tituloPuesto, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "GROUP BY p.tituloPuesto")
	Page<Consulta34> encontrarCantidadEmpleadosPorTituloPuesto(Pageable pageable);
	
	@Query("SELECT DISTINCT new es.iesjandula.examen_ud2.dtos_clase.Consulta45(p.tituloPuesto, p.salarioMin, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.puestos p "
			+ "WHERE p.salarioMin >= 4000 "
			+ "GROUP BY p.tituloPuesto ")
	Page<Consulta45> obtenerPuestosConSalarioMinimoMayor4000YEmpleadosAsignados(Pageable pageable);

}
