package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.models.Alumno;
import ies.jandula.query.models.Tutor;

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
	
	
	
	@Query("SELECT a FROM Alumno a ORDER BY a.edad LIMIT 10")
	List<Alumno> encontrarLos10PrimerosOrdenadosAsc();
	
	@Query("SELECT distinct a.direccion FROM Alumno a")
	List<String> encontrarPorDireccionDistintos(@Param("direccion") String direccion);
	
	@Query("SELECT a FROM Alumno a JOIN a.tutor t WHERE t.nombre = :tutor")
	List<Alumno> encontrarAlumnoPorTutor(@Param("tutor") String tutor);
	
//	List<Alumno> encontrarTutoresConAlumnosMayores18();
	
	@Query("SELECT a FROM Alumno a WHERE a.tutor IN (SELECT a2.tutor FROM Alumno a2 GROUP BY a2.tutor HAVING COUNT (a2.tutor) > 2)")
	List<Alumno> encontrarAlumnosPorTutorCuandoTenga2OMas();
	
	//media de edad de los alumnos
	@Query("SELECT AVG (a.edad) FROM Alumno a")
	Double mediaEdadDeLosAlumnos();
	
	//Cuenta cuántos alumnos de Española tienen como tutor a "pepe"
	@Query("SELECT COUNT(*) FROM Nacionalidad n JOIN n.listaAlumno a JOIN a.tutor t WHERE n.pais = :nombre AND t.nombre = :nombre")
	Double cuantosAlumnosEspaniolesYPepeComoTutor(@Param("pais") String pais, @Param("nombre") String nombre);
	
	//Dime el mentor con más alumnos que tengan como tutor a "pepe"
//	@Query("SELECT a FROM alumno a JOIN a.tutor t WHERE t.nombre = :nombre")
//	Alumno mentorConMasAlumnosConTutorEspecifico(@Param("nombre") String nombre);
	
	//Busca los alumnos que no tienen mentor ni tampoco tutor que sean españoles
	@Query("SELECT a FROM Alumno a WHERE a.tutor is null AND a.mentor is null AND n.nacionalidad.nombre = :nombre ")
	List<Alumno> alumnosSinTutoYSinMentor(@Param("nombre") String nombre);
	
}
