package ies.jandula.Concesionario.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class DescuentoId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 2001421725725128972L;
	
	private int anio;
	
	private String nif;

}
