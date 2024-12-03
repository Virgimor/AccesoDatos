package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	
//	List<Alumno> findByNif(String nif);
//	
//	List<Alumno> findByNifContaining(String nif);
//	
//	List<Alumno> findByEdadLessThan(Integer edad);
//	
//	List<Alumno> findByAprobadoTrue();
//	
//	List<Alumno> findByAprobadoFalse();
//	
//	List<Alumno> findByNifAndEdad(String nif, Integer edad);
//	
//	List<Alumno> findByEdadOrderByEdadAsc(Integer edad);
//	
//	List<Alumno> findTop10ByNifOrderByEdadDesc(String nif);
//
//	List<Alumno> findDistinctByNif(String nif);
//	
//	List<Alumno> findByEdadBetween(Integer edad1, Integer edad2);

	//AlumnoResponse findNifByDireccion(String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion= :direccion")
	List<Alumno>encontrarPorDireccion(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion LIKE %:direccion%")
	List<Alumno>encontrarPorDireccionQueContiene(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.edad<:edad")
	List<Alumno>encontrarPorEdadMenorQue(@Param("edad") Integer edad);
	
}
