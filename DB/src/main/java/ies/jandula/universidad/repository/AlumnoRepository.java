package ies.jandula.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ies.jandula.universidad.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	
	/*
	 * siendo "Alumno" el nombre de la entidad y 
	 * "Long" el tipo de la clave primaria o el que tenga la anotacion @Enbeddable
	 */

}
