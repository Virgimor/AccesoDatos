package es.iesjandula.examen_ud2.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iesjandula.examen_ud2.dtos_clase.Consulta42;
import es.iesjandula.examen_ud2.dtos_clase.Consulta7Y29Y35;
import es.iesjandula.examen_ud2.models.Regiones;

public interface RegionesRepository extends JpaRepository<Regiones, BigDecimal>{
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion")
	List<Consulta7Y29Y35> encontrarRegionesYCantidadPaisesPertenecientes();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais) AS cantidadPaises) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion "
			+ "ORDER BY cantidadPaises ASC")
	List<Consulta7Y29Y35> encontrarRegionesOrdenadaCantidadPaisesPertenecientesOrdenada();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta7Y29Y35(r.idRegion, r.nombreRegion, count(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion")
	List<Consulta7Y29Y35> listarRegionesYCantidadPaisesPertenecientes();
	
	@Query("SELECT new es.iesjandula.examen_ud2.dtos_clase.Consulta42(r.nombreRegion, COUNT(p.idPais)) "
			+ "FROM Paises p "
			+ "JOIN p.regiones r "
			+ "GROUP BY r.idRegion "
			+ "HAVING COUNT(p.idPais)>=3")
	List<Consulta42> mostrarReionesConMas3PaisesAsociados();

}
