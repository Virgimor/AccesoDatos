package ies.jandula.Ejercicio5.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PerteneceId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -4192543622290875222L;
	
	private int numMatricula;
	
	private int codigoAsignatura;
	
	private String curso;
	
	

}
