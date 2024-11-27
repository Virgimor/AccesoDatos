package ies.jandula.Biblioteca.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class PrestamoId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 2580450965923113657L;
	
	private Date fechaPrestamo;
	
	@ManyToOne
	private Libro libro;
	
	@ManyToOne
	private Usuario usuario;

}
