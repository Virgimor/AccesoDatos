package ies.jandula.Ejercicio4.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {
	
	@EmbeddedId
	private EmpleadoId empleadoId;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column
	private Integer telefono;
	
	@Column
	private Double Salario;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Localidad localidad;

}
