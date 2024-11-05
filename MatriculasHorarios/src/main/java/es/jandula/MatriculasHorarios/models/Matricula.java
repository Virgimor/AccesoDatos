package es.jandula.MatriculasHorarios.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Matricula")
public class Matricula {
	
	@EmbeddedId
	private MatriculaId matriculaId;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "asignatura_curso", referencedColumnName = "curso"),
		@JoinColumn(name = "asignatura_etapa", referencedColumnName = "etapa"),
		@JoinColumn(name = "asignatura_grupo", referencedColumnName = "grupo"),
		@JoinColumn(name = "asignatura_nombre", referencedColumnName = "nombre")
	})
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name = "alumno_id")
	@MapsId("alumnoId")
	private Alumno alumnoId;


}
