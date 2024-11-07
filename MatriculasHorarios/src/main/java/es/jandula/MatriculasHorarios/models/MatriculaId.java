package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MatriculaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8190860470095335301L;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "asignatura_curso", referencedColumnName = "curso"),
		@JoinColumn(name = "asignatura_etapa", referencedColumnName = "etapa"),
		@JoinColumn(name = "asignatura_grupo", referencedColumnName = "grupo"),
		@JoinColumn(name = "asignatura_nombre", referencedColumnName = "nombre")
	})
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name = "alumno_id", referencedColumnName = "id")
	private Alumno alumnoId;


}
