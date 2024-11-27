package ies.jandula.Biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Prestamo {
	
	@EmbeddedId
	private PrestamoId prestamoId;
	
	@Column(length = 50)
	private String estado;

}
