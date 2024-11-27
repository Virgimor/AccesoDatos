package ies.jandula.Biblioteca.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class RevistaId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7367061376206964882L;
	
	private String titulo;
	
	private String editorial;

}
