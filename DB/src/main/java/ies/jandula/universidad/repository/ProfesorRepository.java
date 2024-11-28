package ies.jandula.universidad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.models.Asignatura;
import ies.jandula.universidad.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	
//	List<Profesor> findBySexo(String sexo);
	
//	List<Profesor> findTop10ByOrderByFechaNacimientoDesc();
	
	//List<Asignatura> findTop10ByFechaNacimientoDesc(String nombre);

}
