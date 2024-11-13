package ies.jandula.Ejercicio5.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alumno {
	
	@Id
	@Column(nullable = false)
	private Integer numMatricula;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column
	private Date fechaNacimiento;
	
	@Column
	private Integer telefono;

}
