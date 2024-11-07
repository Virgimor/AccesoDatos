package ies.jandula.universidad.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MatriculaId implements Serializable{

	/**
	 * Esta es la primera clase que se tiene que hacer con los atributos que forman
	 * la clave primaria
	 */
	private static final long serialVersionUID = -8406426180278818175L;
	
	private Long idAlumno;
	
	private Long idAsignatura;
	
	private Long idCurso;

}
