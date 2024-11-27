package ies.jandula.Biblioteca.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class EventoId implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 6861764777238241621L;
	
	private String nombre;
	
	private Date fecha;

}
