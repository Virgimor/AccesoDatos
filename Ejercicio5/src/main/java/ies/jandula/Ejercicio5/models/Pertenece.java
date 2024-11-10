package ies.jandula.Ejercicio5.models;

import jakarta.persistence.Column;
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
	private PerteneceId perteneceId;
	
	@Column(length = 10, nullable = false)
	private String curso;
	
	@ManyToOne
	@MapsId("numMatricula")
	@JoinColumn(name = "num_matricula_alumno")
	private Alumno alumno;
	
	@ManyToOne
	@MapsId("codigoAsignatura")
	@JoinColumn(name = "codigo_asignatura_asignatura")
	private Asignatura asignatura;
	

}
