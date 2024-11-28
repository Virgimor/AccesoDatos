package ies.jandula.universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Profesor;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{
	
	List<Asignatura> findTop10ByIdProfesorOrderByCreditosDesc(Profesor id);

	List<Asignatura> findByCreditosGreaterThan(int creditos);

	List<Asignatura> findByIdProfesorOrderByNombreAsc(Profesor id);
	
	List<Asignatura> findByNombreContaining(String palabra);
	
	List<Asignatura> findTop3ByOrderByCreditosDesc();
}
