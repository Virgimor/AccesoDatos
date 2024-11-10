package ies.jandula.Ejercicio5.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Asignatura {
	
	@Id
	@Column(nullable = false)
	private Integer codigoAsignatura;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Profesor profesor;

}
