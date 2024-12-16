package ies.jandula.universidad.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ies.jandula.universidad.dtos.AlumnoProfesorDto;
import ies.jandula.universidad.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	@Query("SELECT new ies.jandula.universidad.dtos.AlumnoProfesorDto(alu.nombreAlumno, pro.nombreProfesor) FROM Profesor pro JOIN Asignatura a ON a.idProfesor.id = pro.id JOIN Matricula m ON m.idAsignatura.id = a.id JOIN Alumno alu ON alu.id = m.idAlumno WHERE alu.fechaNacimiento = pro.fechaNacimiento")
	List<AlumnoProfesorDto> alumnoYProfesorMismaEdad(Pageable pageable);

}
