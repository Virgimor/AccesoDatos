package es.jandula.MatriculasHorarios.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProfesorReduccionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7939383005338147610L;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "email")
	private Profesor profesor;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "nombre")
	private Reduccion reduccion;

}
