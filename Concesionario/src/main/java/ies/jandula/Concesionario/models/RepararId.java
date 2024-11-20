package ies.jandula.Concesionario.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RepararId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 264055639328062746L;
	
	private String matriculaCoche;
	
	private String dniMecanico;
	
	private Date fechaReparacion;

}
