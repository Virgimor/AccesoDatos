package ies.jandula.empleados.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.empleados.dtos.Consulta3y23;
import ies.jandula.empleados.dtos.Consulta6;
import ies.jandula.empleados.models.Ubicaciones;

public interface UbicacionesRepository extends JpaRepository<Ubicaciones, BigDecimal>{
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta3y23(u.direccion, u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p")
	Page<Consulta3y23> encontrarUbicacionConCiudadYPais(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta6(u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p")
	List<Consulta6> encontrarUbicacionConNombrePais();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta6(u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE p.nombrePais LIKE :letra%")
	List<Consulta6> encontrarUbicacionConNombrePaisEmpiezanPorC(@Param("letra") Character letra);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta3y23(u.direccion, u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "ORDER BY u.ciudad ASC, p.nombrePais ASC")
	Page<Consulta3y23> encontrarUbicacionOrdenadaPorCiudadAscYNombrePais(Pageable pageable);
	
	 @Query("SELECT u.ciudad, COUNT(u.idUbicacion) " +
	           "FROM Ubicaciones u " +
	           "GROUP BY u.ciudad " +
	           "HAVING COUNT(u.idUbicacion) > 2")
	 List<Ubicaciones> obtenerCiudadesConMas2Ubicaciones();

}
