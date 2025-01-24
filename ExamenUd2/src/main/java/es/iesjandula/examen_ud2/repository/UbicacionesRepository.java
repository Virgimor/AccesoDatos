package es.iesjandula.examen_ud2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iesjandula.examen_ud2.dtos_clase.Consulta3y23;
import es.iesjandula.examen_ud2.dtos_clase.Consulta52;
import es.iesjandula.examen_ud2.dtos_clase.Consulta6Y15;
import es.iesjandula.examen_ud2.models.Ubicaciones;

public interface UbicacionesRepository extends JpaRepository<Ubicaciones, BigDecimal>{
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta3y23(u.direccion, u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p")
	Page<Consulta3y23> encontrarUbicacionConCiudadYPais(Pageable pageable);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta6Y15(u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p")
	List<Consulta6Y15> encontrarUbicacionConNombrePais();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta6Y15(u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "WHERE p.nombrePais LIKE :letra%")
	List<Consulta6Y15> encontrarUbicacionConNombrePaisEmpiezanPorC(@Param("letra") Character letra);
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta3y23(u.direccion, u.ciudad, p.nombrePais) "
			+ "FROM Ubicaciones u "
			+ "JOIN u.paises p "
			+ "ORDER BY u.ciudad ASC, p.nombrePais ASC")
	Page<Consulta3y23> encontrarUbicacionOrdenadaPorCiudadAscYNombrePais(Pageable pageable);
	
	 @Query("SELECT u.ciudad, COUNT(u.idUbicacion) " +
	           "FROM Ubicaciones u " +
	           "GROUP BY u.ciudad " +
	           "HAVING COUNT(u.idUbicacion) > 2")
	 List<Ubicaciones> obtenerCiudadesConMas2Ubicaciones();
	 
	 @Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta52(u.direccion, p.nombrePais, r.nombreRegion) "
				+ "FROM Ubicaciones u "
				+ "JOIN u.paises p "
				+ "JOIN p.regiones r")
	Page<Consulta52> mostrarDireccionNombreDePaisYRegion(Pageable pageable);

}
