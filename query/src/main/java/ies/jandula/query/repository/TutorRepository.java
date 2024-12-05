package ies.jandula.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ies.jandula.query.models.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Integer>{
	
	@Query("SELECT t FROM Tutor t JOIN t.listaAlumno a WHERE a.nif = :nif")
	List<Tutor> encontrarTutorPorNifAlumno(@Param("nif") String nif);

}
