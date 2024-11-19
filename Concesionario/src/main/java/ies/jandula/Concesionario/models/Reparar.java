package ies.jandula.Concesionario.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Reparar {
	
	@EmbeddedId
	private RepararId repararId;
	
	@ManyToOne
	@MapsId("nifCliente")
	@JoinColumn(name = "nif_cliente")
	private Cliente nifCliente;
	
	@ManyToOne
	@MapsId("dniMecanico")
	@JoinColumn(name = "dni_mecanico")
	private Mecanico dniMecanico;

}
