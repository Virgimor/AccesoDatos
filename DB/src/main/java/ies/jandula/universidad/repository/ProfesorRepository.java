package ies.jandula.universidad.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.universidad.dtos.AlumnoProfesorDto;
import ies.jandula.universidad.models.Departamento;
import ies.jandula.universidad.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
	
	List<Profesor> findBySexo(String sexo);
	
	List<Profesor> findTop10ByOrderByFechaNacimientoDesc();
	
	List<Profesor> findTop5ByOrderByFechaNacimientoDesc();
	
	List<Profesor> findByIdDepartamento(Departamento id);
	
	List<Profesor> findByNombreStartingWith(String palabra);
	
	@Query("SELECT new ies.jandula.universidad.dtos.AlumnoProfesorDto(alu.nombre, pro.nombre) "
			+ "FROM Profesor pro JOIN Asignatura a ON a.idProfesor.id = pro.id JOIN Matricula m ON m.idAsignatura.id = a.id JOIN Alumno alu ON alu.id = m.idAlumno.id "
			+ "WHERE alu.fechaNacimiento = pro.fechaNacimiento")
	Page<AlumnoProfesorDto> alumnoYProfesorMismaEdad(Pageable pageable);

}
