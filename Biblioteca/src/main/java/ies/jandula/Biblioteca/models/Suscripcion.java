package ies.jandula.Biblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Suscripcion {
	
	@EmbeddedId
	private SuscripcionId suscripcionId;
	
	@Column
	private String estado;

}
