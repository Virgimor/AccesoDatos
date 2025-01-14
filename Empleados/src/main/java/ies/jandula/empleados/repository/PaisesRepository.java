package ies.jandula.empleados.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.empleados.dtos.Consulta13;
import ies.jandula.empleados.dtos.Consulta2Y22;
import ies.jandula.empleados.dtos.Consulta33Y46;
import ies.jandula.empleados.dtos.Consulta49;
import ies.jandula.empleados.dtos.Consulta67;
import ies.jandula.empleados.models.Paises;

public interface PaisesRepository extends JpaRepository<Paises, Character>{
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta2Y22(p.nombrePais, r.nombreRegion) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r")
	Page<Consulta2Y22> encontrarPaisesYNombreRegion(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta13(p.nombrePais, r.nombreRegion) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "WHERE r.nombreRegion = :nombreRegion")
	List<Consulta13> encontrarPaisesDeEuropa(@Param("nombreRegion") String nombreRegion);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta2Y22(p.nombrePais, r.nombreRegion) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "ORDER BY r.nombreRegion DESC")
	Page<Consulta2Y22> encontrarPaisesOrdenadorPorNombreRegion(Pageable pageable);
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta33Y46(p.nombrePais, COUNT(u.idUbicacion)) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "GROUP BY p.idPais")
	List<Consulta33Y46> encontrarPaisesConNumeroUbicacionPorPais();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta33Y46(p.nombrePais, COUNT(u.idUbicacion)) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "GROUP BY p.idPais "
			+ "HAVING COUNT(u.idUbicacion) >= 2")
	List<Consulta33Y46> listarPaisesConMas2Ubicaciones();
	
	@Query("SELECT new ies.jandula.empleados.dtos.Consulta49(p.nombrePais, COUNT(e.idEmpleado)) "
			+ "FROM Empleados e "
			+ "JOIN e.departamentos d "
			+ "JOIN d.ubicaciones u "
			+ "JOIN u.paises p "
			+ "GROUP BY p.nombrePais "
			+ "HAVING COUNT(e.idEmpleado) > 3")
	List<Consulta49> mostrarPaisesConMas3Empleados();
	
//	@Query("SELECT p.nombrePais "
//			+ "FROM Paises p "
//			+ "WHERE NOT EXISTS "
//				+ "(SELECT u.paises.id "
//				+ "FROM Ubicaciones u "
//				+ "WHERE u.paises.idPais = p.idPais)")
	@Query("SELECT p.nombrePais "
			+ "FROM Paises p "
			+ "WHERE p.idPais NOT IN "
				+ "(SELECT u.paises.id "
				+ "FROM Ubicaciones u)")
	Page<String> mostrarPaisesSinUbicaciones(Pageable pageable);

}
