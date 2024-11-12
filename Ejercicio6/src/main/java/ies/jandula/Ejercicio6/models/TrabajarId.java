package ies.jandula.Ejercicio6.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class TrabajarId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8706375964394365048L;
	
	private int codigo;
	
	private String nif;

}
