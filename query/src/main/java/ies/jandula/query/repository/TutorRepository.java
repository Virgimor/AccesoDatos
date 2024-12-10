package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.models.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Integer>{
	
	@Query("SELECT t FROM Tutor t JOIN t.listaAlumno a WHERE a.nif = :nif")
	List<Tutor> encontrarTutorPorNifAlumno(@Param("nif") String nif);
	
//	CONSULTAS JOIN
	
//	@Query("SELECT tu FROM Tutor tu JOIN tu.listaAlumno alu WHERE alu.nif = :nif")
//	List<Tutor> encontrarTutorPorNifAlumnoEspecifico(@Param("nif") String nif);
	@Query("SELECT tu FROM Tutor tu JOIN tu.listaAlumno alu WHERE alu.nif = :nif ORDER BY alu.edad ASC LIMIT 1")
	Tutor encontrarTutorPorNifAlumnoEspecifico(@Param("nif") String nif);
	
	@Query("SELECT tu FROM Tutor tu JOIN tu.listaAlumno alu GROUP BY tu.id HAVING COUNT(alu.id)>=3")
	List<Tutor> encontrarTutoresCon3oMasAlumnos();
	
//	CONSULTAS CON JOIN DE PACO
	
	@Query("SELECT t FROM Tutor t JOIN t.listaAlumno alu WHERE alu.edad > 18")
	List<Tutor> encontrarTutoresConAlumnosMayores18();
	
	@Query("SELECT t FROM Tutor t JOIN t.listaAlumno alu WHERE alu.mentor is null")
	Tutor encontrarTutor(); 

}
