package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.dto.InfoAlumnoDto;
import ies.jandula.query.dto.AprobadoAlumnoDto;
import ies.jandula.query.dto.EdadAlumnoDto;
import ies.jandula.query.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	
	List<Alumno> findByNif(String nif);
	
	List<Alumno> findByNifContaining(String nif);
	
	List<Alumno> findByEdadLessThan(Integer edad);
	
	List<Alumno> findByAprobadoTrue();
	
	List<Alumno> findByAprobadoFalse();
	
	List<Alumno> findByDireccionAndEdad(String direccion, Integer edad);
	
	List<Alumno> findByDireccionOrEdad(String direccion, Integer edad);
	
	List<Alumno> findByNifOrderByEdadAsc(String nif);
	
	List<Alumno> findByNifOrderByEdadDesc(String nif);
	
	List<Alumno> findTop10ByNifOrderByEdadDesc(String nif);
	
	List<Alumno> findDistinctByNif(String nif);
	
	List<Alumno> findByEdadBetween(Integer edad1, Integer edad2);
	
//	Consultas con SELECT

	@Query("SELECT a FROM Alumno a WHERE a.direccion= :direccion")
	List<Alumno>encontrarPorDireccion(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion LIKE %:direccion%")
	List<Alumno>encontrarPorDireccionQueContiene(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.edad<:edad")
	List<Alumno>encontrarPorEdadMenorQue(@Param("edad") Integer edad);
	
	@Query("SELECT a FROM Alumno a WHERE a.aprobado = true")
	List<Alumno> encontrarPorAprobados();
	
	@Query("SELECT a FROM Alumno a WHERE a.aprobado = false")
	List<Alumno> encontrarPorSuspensos();
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion = :direccion AND a.edad = :edad")
	List<Alumno> encontrarDireccionYEdad(@Param("direccion") String direccion, @Param("edad") Integer edad);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion = :direccion OR a.edad = :edad")
	List<Alumno> encontrarDireccionOEdad(@Param("direccion") String direccion, @Param("edad") Integer edad);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion = :direccion ORDER BY a.edad ASC")
	List<Alumno> encontrarDireccionOrdenadoPorEdadAsc(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.direccion = :direccion ORDER BY a.edad DESC")
	List<Alumno> encontrarDireccionOrdenadoPorEdadDesc(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a ORDER BY a.edad ASC LIMIT 10")
	List<Alumno> encuentra10PrimerosOrdenadosPorEdadAsc();
	
	@Query("SELECT distinct a.direccion FROM Alumno a")
	List<String> encontrarDireccionesDistintas();
	
	@Query("SELECT a FROM Alumno a WHERE LOWER(a.direccion) = LOWER(:direccion)")
	List<Alumno> encontrarPorDireccionIgnardoMayusculas(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a WHERE a.edad BETWEEN :edad1 AND :edad2")
	List<Alumno> encontrarAlumnoEntre2Edades(@Param("edad1") Integer edad1, @Param("edad2") Integer edad2);
	
//	Consultas con JOIN
	
	@Query("SELECT alu FROM Alumno alu JOIN alu.tutor tu WHERE tu.nombre = :nombre")
	List<Alumno> encontrarPorElNombreDelTutor(@Param("nombre") String nombre);
	
	@Query("SELECT alu FROM Alumno alu JOIN alu.tutor tu WHERE tu.nombre = :nombre ORDER BY alu.edad ASC")
	List<Alumno> encontrarPorElNombreDelTutorOrdenadorPorEdadAsc(@Param("nombre") String nombre);
	
	@Query("SELECT AVG(alu.edad) FROM Alumno alu JOIN alu.tutor tu WHERE tu.nombre = :nombre")
	Double edadPromedioAlumnosDeTutorEspecifico(@Param("nombre") String nombre);
	
	@Query("SELECT COUNT(alu.edad) FROM Alumno alu JOIN alu.tutor tu WHERE tu.nombre = :nombre")
	Integer numeroAlumnosDeTutorEspecifico(@Param("nombre") String nombre);
	
	@Query("SELECT AVG(alu.edad) FROM Alumno alu JOIN alu.tutor tu GROUP BY tu.nombre")
	List<Double> edadPromedioAlumnosAgrupadosPorTutor();
	
	@Query("SELECT COUNT(alu.edad) FROM Alumno alu JOIN alu.tutor tu GROUP BY tu HAVING COUNT(alu)>=3")
	List<Integer> numeroAlumnosDeTutorEspecificoConMasDe3Alumnos();
	
	@Query("SELECT SUM(alu.edad) FROM Alumno alu JOIN alu.tutor tu WHERE tu.nombre = :nombre")
	Integer sumaEdadesAlumnosDeTutorEspecifico(@Param("nombre") String nombre);
	
//	Consultas con JOIN de Paco
	
	@Query("SELECT a FROM Alumno a JOIN a.tutor t WHERE t.nombre = :tutor")
	List<Alumno> encontrarAlumnoPorTutor(@Param("tutor") String tutor);
	
	@Query("SELECT a FROM Alumno a WHERE a.tutor IN (SELECT a2.tutor FROM Alumno a2 GROUP BY a2.tutor HAVING COUNT (a2.tutor) > 2)")
	List<Alumno> encontrarAlumnosPorTutorCuandoTenga2OMas();
	
	//media de edad de los alumnos
	@Query("SELECT AVG (a.edad) FROM Alumno a")
	Double mediaEdadDeLosAlumnos();
	
	//Cuenta cuántos alumnos de Española tienen como tutor a "pepe"
	@Query("SELECT COUNT(*) FROM Nacionalidad n JOIN n.listaAlumno a JOIN a.tutor t WHERE n.nombre = :nacionalidad AND t.nombre = :nombre")
	Double cuantosAlumnosEspaniolesYPepeComoTutor(@Param("nacionalidad") String nacionalidad, @Param("nombre") String nombre);
	
	//Dime el mentor con más alumnos que tengan como tutor a "pepe"
	@Query("SELECT a.mentor FROM Alumno a JOIN a.tutor tu WHERE tu.nombre = :nombre GROUP BY a.mentor ORDER BY COUNT(a) DESC LIMIT 1")
//	@Query("SELECT a.mentor " +
//	       "FROM Alumno a " +
//	       "WHERE a.tutor.id = ("
//	       			+ "SELECT tu.id "
//	       			+ "FROM Tutor tu "
//	       			+ "WHERE tu.nombre = :nombre) " +
//	       "GROUP BY a.mentor " +
//	       "ORDER BY COUNT(a) DESC " +
//	       "LIMIT 1")
	Alumno mentorConMasAlumnosConTutorEspecifico(@Param("nombre") String nombre);
	
	//Busca los alumnos que no tienen mentor ni tampoco tutor que sean españoles
	@Query("SELECT a FROM Alumno a JOIN a.nacionalidad n WHERE a.tutor is null AND a.mentor is null AND a.nacionalidad.nombre = :nombre")
	List<Alumno> alumnosSinTutoYSinMentor(@Param("nombre") String nombre);
	
	
	@Query("SELECT new ies.jandula.query.dto.InfoAlumnoDto("+
			"alu.nif, alu.tutor.nombre)"+
			"FROM Alumno alu WHERE alu.edad>18")
	List<InfoAlumnoDto> encontrarTutorEspecifico();
	
	//Dime el numero de alumnos con cada edad
	@Query("SELECT new ies.jandula.query.dto.EdadAlumnoDto(alu.edad, Count(alu)) from Alumno alu GROUP BY alu.edad")
	List<EdadAlumnoDto> encontrarNumeroAlumnosEdadQuery();
	
	
	@Query("SELECT new ies.jandula.query.dto.AprobadoAlumnoDto("
			+ "alu.nacionalidad.pais, COUNT(alu))"
			+ "FROM Alumno alu WHERE alu.aprobado = true GROUP BY alu.nacionalidad")
	List<AprobadoAlumnoDto> numeroAprobadosPorPais();
	
	@Query("SELECT new ies.jandula.query.dto.AlumnoDto("+
			"alu.id, alu.nif, alu.edad, alu.direccion, alu.aprobado, alu.tutor.id, alu.tutor.nombre, alu.nacionalidad.nombre, alu.nacionalidad.pais, alu.mentor.id, alu.mentor.nif, alu.mentor.edad, alu.mentor.direccion, alu.mentor.aprobado )"+
			"FROM Alumno alu")
	List<InfoAlumnoDto> encontrarAlumnoDto();
	
}
