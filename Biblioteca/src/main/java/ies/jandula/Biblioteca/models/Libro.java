package ies.jandula.Biblioteca.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Libro {
	
	@EmbeddedId
	private LibroId libroId;
	
	@ManyToOne
	private Sala sala;

}
