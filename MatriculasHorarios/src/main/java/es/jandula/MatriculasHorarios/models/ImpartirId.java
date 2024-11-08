package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
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
public class ImpartirId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -5101037630905419290L;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "asignatura_curso", referencedColumnName = "curso"),
		@JoinColumn(name = "asignatura_etapa", referencedColumnName = "etapa"),
		@JoinColumn(name = "asignatura_grupo", referencedColumnName = "grupo"),
		@JoinColumn(name = "asignatura_nombre", referencedColumnName = "nombre")
	})
	private Asignatura asignatura;
	
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "email")
	private Profesor profesor;

}
