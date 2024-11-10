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
public class PerteneceId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6824899997662918139L;
	
	private String dni;
	
	@ManyToOne
	private Curso curso;

}
