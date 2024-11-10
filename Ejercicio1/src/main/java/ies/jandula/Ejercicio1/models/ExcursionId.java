package ies.jandula.Ejercicio1.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ExcursionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966566748115245367L;
	
	private String nif;
	
	@ManyToOne
	private Curso curso;

}
