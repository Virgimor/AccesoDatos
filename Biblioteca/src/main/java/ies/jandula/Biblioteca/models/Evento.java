package ies.jandula.Biblioteca.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {
	
	@EmbeddedId
	private EventoId eventoId;
	
	@ManyToOne
	@JoinColumn(name = "sala_evento", referencedColumnName = "nombre")
	private Sala sala;

}
