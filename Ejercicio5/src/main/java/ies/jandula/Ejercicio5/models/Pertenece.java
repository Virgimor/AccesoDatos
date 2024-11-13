package ies.jandula.Ejercicio5.models;

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
public class Pertenece {
	
	@EmbeddedId
	private PerteneceId perteneceId = new PerteneceId();
	
	@ManyToOne
	@MapsId("numMatricula")
	@JoinColumn(name = "num_matricula_alumno")
	private Alumno alumno;
	
	@ManyToOne
	@MapsId("codigoAsignatura")
	@JoinColumn(name = "codigo_asignatura_asignatura")
	private Asignatura asignatura;
	
	@Column(length = 20, nullable = false)
	private String curso;
	

}
