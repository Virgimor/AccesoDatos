package ies.jandula.Biblioteca.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class LibroId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7062020541156060852L;
	
	private String titulo;
	
	private String autor;
	
	private int anioPublicacion;

}
