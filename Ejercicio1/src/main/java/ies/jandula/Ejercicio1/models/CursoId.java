package ies.jandula.Ejercicio1.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CursoId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 8675649915666786497L;
	
	private int identificador;
	
	private String anioAcademico;

}
