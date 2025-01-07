package ies.jandula.empleados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.empleados.dtos.Consulta42;
import ies.jandula.empleados.dtos.Consulta7Y29Y35;
import ies.jandula.empleados.models.Regiones;

public interface RegionesRepository extends JpaRepository<Regiones, BigDecimal>{
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion")
	List<Consulta7Y29Y35> encontrarRegionesYCantidadPaisesPertenecientes();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais) AS cantidadPaises) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion "
			+ "ORDER BY cantidadPaises ASC")
	List<Consulta7Y29Y35> encontrarRegionesOrdenadaCantidadPaisesPertenecientesOrdenada();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion")
	List<Consulta7Y29Y35> listarRegionesYCantidadPaisesPertenecientes();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta42(r.nombreRegion, COUNT(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion "
			+ "HAVING COUNT(p.idPais)>=3")
	List<Consulta42> mostrarReionesConMas3PaisesAsociados();

}
