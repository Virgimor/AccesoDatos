package ies.jandula.universidad.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase es igual que la de Profesor con su Entity 
 * 
 * En esta clase si los atributos definidos en la anterior clase a parte de ser
 * clave primaria también son clave foranea tendras que definirlos aquí también
 */

@Data
@NoArgsConstructor
@Entity
public class Matricula {
	
	/*
	 * Con EmbeddedId le digo a Entity que esa clase es la clave primaria
	 */
	
	@EmbeddedId
	private MatriculaId matriculaId = new MatriculaId();
	
	@ManyToOne
	@JoinColumn(name="id_alumno")
	@MapsId("idAlumno")
	private Alumno idAlumno;
	
	@ManyToOne
	@JoinColumn(name="id_asignatura")
	@MapsId("idAsignatura")
	private Asignatura idAsignatura;
	
	@ManyToOne
	@JoinColumn(name="id_curso")
	@MapsId("idCurso")
	private Curso idCurso;

}
