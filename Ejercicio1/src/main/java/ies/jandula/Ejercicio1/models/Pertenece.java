package ies.jandula.Ejercicio1.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pertenece {
	
	@EmbeddedId
	private PerteneceId pertenece;
	
	@ManyToOne
	@JoinColumn(name = "dni_alumno")
	@MapsId("dni")
	private Alumno alumno;
	
}
