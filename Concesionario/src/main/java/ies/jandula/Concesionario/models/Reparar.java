package ies.jandula.Concesionario.models;

import jakarta.persistence.Column;
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
	@MapsId("matriculaCoche")
	@JoinColumn(name = "matricula_coche")
	private Coche matriculaCoche;
	
	@ManyToOne
	@MapsId("dniMecanico")
	@JoinColumn(name = "dni_mecanico")
	private Mecanico dniMecanico;
	
	@Column(nullable = false)
	private Double horasEnArreglar;

}
